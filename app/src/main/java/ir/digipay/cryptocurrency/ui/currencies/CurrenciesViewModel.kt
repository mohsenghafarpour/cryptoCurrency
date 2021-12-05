package ir.digipay.cryptocurrency.ui.currencies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.digipay.cryptocurrency.base.BaseViewModel
import ir.digipay.cryptocurrency.network.ResultCall
import ir.digipay.cryptocurrency.repository.CurrenciesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrenciesViewModel @Inject constructor(
    private val repo: CurrenciesRepository,
    private val mapper: CurrenciesDataMapper
) : BaseViewModel() {

    private val _currencies = MutableLiveData<List<Any>>()
    val currencies: LiveData<List<Any>>
        get() = _currencies

    private var cacheData = mutableListOf<Any>()

    private var pageSize: Int = 20

    fun getData(page: Int = 1) {
        viewModelScope.launch {
            when (val result = repo.getCurrencies(page)) {
                is ResultCall.Success -> {
                    cacheData = mapper.map(result.data.data, cacheData)
                    _currencies.value = cacheData
                }
                is ResultCall.Error -> {
                    Log.d("aaa", "error: $result")
                }
            }
        }
    }

    fun getNextPageData(page: Int) {
        getData(pageSize * page)
    }
}
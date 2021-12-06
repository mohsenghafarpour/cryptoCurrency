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
    private val mapper: CurrenciesDataMapper,
) : BaseViewModel() {

    private var cacheData = mutableListOf<Any>()

    private val _currencies = MutableLiveData<List<Any>>()
    val currencies: LiveData<List<Any>>
        get() = _currencies

    fun getData(start: Int = 1, sort: String = "market_cap", isFilter: Boolean = false) {
        showProgress()
        viewModelScope.launch {
            when (val result = repo.getCurrencies(start, sort)) {
                is ResultCall.Success -> {
                    hideProgress()
                    hideNoData()
                    if (isFilter) {
                        cacheData.clear()
                        _currencies.value = emptyList()
                    }
                    cacheData = mapper.map(result.data.data, cacheData)
                    _currencies.value = cacheData
                }
                is ResultCall.Error -> {
                    hideProgress()
                    showNoData()
                    Log.d("aaa", "error: $result")
                }
            }
        }
    }
}
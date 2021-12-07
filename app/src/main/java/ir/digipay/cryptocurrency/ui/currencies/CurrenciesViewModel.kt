package ir.digipay.cryptocurrency.ui.currencies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.digipay.cryptocurrency.base.BaseViewModel
import ir.digipay.cryptocurrency.network.ResultCall
import ir.digipay.cryptocurrency.repository.CurrenciesRepository
import ir.digipay.cryptocurrency.utils.QueryParams
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrenciesViewModel @Inject constructor(
    private val repo: CurrenciesRepository,
    private val mapper: CurrenciesDataMapper,
) : BaseViewModel() {

    private var queryParams = QueryParams.Builder().addStart(1).build()

    private var cacheData = mutableListOf<Any>()

    private val _currencies = MutableLiveData<List<Any>>()
    val currencies: LiveData<List<Any>>
        get() = _currencies

    fun getData(queryParams: QueryParams? = null) {
        showProgress()
        viewModelScope.launch {
            when (val result =
                repo.getCurrencies(queryParams ?: this@CurrenciesViewModel.queryParams)) {
                is ResultCall.Success -> {
                    hideProgress()
                    hideNoData()
                    cacheData = mapper.map(result.data.data, cacheData)
                    _currencies.value = cacheData.toList()
                }
                is ResultCall.Error -> {
                    hideProgress()
                    showNoData()
                }
            }
        }
    }

    fun updateQueryParams(queryParams: QueryParams) {
        this.queryParams = queryParams
        getData()
    }

    fun clearCacheData() {
        this.cacheData.clear()
    }
}
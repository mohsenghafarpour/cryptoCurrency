package ir.digipay.cryptocurrency.ui.currencies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.digipay.cryptocurrency.base.BaseViewModel
import ir.digipay.cryptocurrency.model.Currency
import ir.digipay.cryptocurrency.network.ResultCall
import ir.digipay.cryptocurrency.repository.CurrenciesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrenciesViewModel @Inject constructor(private val repo: CurrenciesRepository) :
    BaseViewModel() {

    private val _currencies = MutableLiveData<List<Currency>>()
    val currencies: LiveData<List<Currency>?>
        get() = _currencies

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            when (val result = repo.getCurrencies()) {
                is ResultCall.Success -> {
                    _currencies.value = result.data.data
                }
                is ResultCall.Error -> {
                    Log.d("aaa", "error: $result")
                }
            }
        }
    }
}
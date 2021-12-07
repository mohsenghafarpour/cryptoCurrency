package ir.digipay.cryptocurrency.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ir.digipay.cryptocurrency.base.BaseViewModel
import ir.digipay.cryptocurrency.model.CurrencyModel


class CoinDetailsViewModel : BaseViewModel() {

    private val _currency = MutableLiveData<CurrencyModel>()
    val currency: LiveData<CurrencyModel>
        get() = _currency

    fun setArgs(currency: CurrencyModel) {
        _currency.value = currency
    }
}
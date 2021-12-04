package ir.digipay.cryptocurrency.ui.currencies

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.digipay.cryptocurrency.base.BaseViewModel
import ir.digipay.cryptocurrency.network.ResultCall
import ir.digipay.cryptocurrency.repository.CurrenciesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrenciesViewModel @Inject constructor(private val repo: CurrenciesRepository) :
    BaseViewModel() {

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            when (val result = repo.getCurrencies()) {
                is ResultCall.Success -> {
                    Log.d("aaa", "getData: ${result.data}")
                }
                is ResultCall.Error -> {
                    Log.d("aaa", "error: $result")
                }
            }
        }
    }
}
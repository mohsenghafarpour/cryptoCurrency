package ir.digipay.cryptocurrency.ui.main

import androidx.lifecycle.MutableLiveData
import ir.digipay.cryptocurrency.base.BaseViewModel
import ir.digipay.cryptocurrency.utils.QueryParams

class MainViewModel : BaseViewModel() {
    val queryParams = MutableLiveData<QueryParams>()
}
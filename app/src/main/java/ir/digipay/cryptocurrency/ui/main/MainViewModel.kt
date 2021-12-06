package ir.digipay.cryptocurrency.ui.main

import androidx.lifecycle.MutableLiveData
import ir.digipay.cryptocurrency.base.BaseViewModel

class MainViewModel : BaseViewModel() {

    val sortValue = MutableLiveData<String>()

    val sortDirValue = MutableLiveData<String>()


}
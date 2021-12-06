package ir.digipay.cryptocurrency.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    val isVisibleNoData = MutableLiveData(true)

    val showLoading = MutableLiveData(true)

    open fun showProgress() {
        showLoading.postValue(true)
    }

    open fun hideProgress() {
        showLoading.value = false
    }

    open fun hideNoData() {
        isVisibleNoData.value = false
    }

    open fun showNoData() {
        isVisibleNoData.value = true
    }

}
package ir.digipay.cryptocurrency.utils.ba

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import ir.digipay.cryptocurrency.cv.NoDataView

@BindingAdapter("loading")
fun NoDataView.setLoading(isLoading: Boolean?) {
    this.isLoading = isLoading == true
}

@BindingAdapter("isVisibleNoData")
fun NoDataView.setValueData(isVisible: MutableLiveData<Boolean>) {
    isVisible.value?.let {
        handleNoData(it)
    }
}

package ir.digipay.cryptocurrency.cv

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import ir.digipay.cryptocurrency.databinding.CvNoDataBinding
import ir.digipay.cryptocurrency.utils.ktx.gone
import ir.digipay.cryptocurrency.utils.ktx.visible

class NoDataView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    var binding: CvNoDataBinding? = null

    var isLoading: Boolean = false
        set(value) {
            field = value
            handleLoadingState(value)
        }

    init {
        val inflater = LayoutInflater.from(context)
        binding = CvNoDataBinding.inflate(inflater, this, true)
        isClickable = true
        isFocusable = true
    }

    private fun handleLoadingState(loading: Boolean) {
        if (loading) {
            showLoadingView()
        } else {
            hideLoadingView()
        }
    }

    private fun hideLoadingView() {
        binding?.cvProgress?.gone()
    }

    private fun hideEmptyView() {
        binding?.iconValue?.gone()
        binding?.txtValue?.gone()
        binding?.btnSubmit?.gone()
    }

    private fun showEmptyView(){
        binding?.iconValue?.visible()
        binding?.txtValue?.visible()
        binding?.btnSubmit?.visible()
    }

    private fun showLoadingView() {
        visible()
        hideEmptyView()
        binding?.cvProgress?.visible()
    }

    /**
     * Gone means the parent is gone with either loading state or empty data state
     */
    fun handleNoData(isVisible: Boolean) {
        if (isVisible) showEmptyView()
        else gone()
    }

    fun setOnRetryClickListener(listener: () -> Unit) {
        binding?.btnSubmit?.setOnClickListener {
            listener()
            handleLoadingState(true)
            hideEmptyView()
        }
    }

}
package ir.digipay.cryptocurrency.ui.filter

import android.view.ViewAnimationUtils
import androidx.fragment.app.viewModels
import ir.digipay.cryptocurrency.R
import ir.digipay.cryptocurrency.base.BaseDialogFragment
import ir.digipay.cryptocurrency.databinding.DialogFilterBinding
import android.util.DisplayMetrics

class FilterDialog : BaseDialogFragment<FilterViewModel, DialogFilterBinding>() {

    override val viewModel: FilterViewModel by viewModels()

    override val layoutRes: Int = R.layout.dialog_filter

    override fun config() {
        setAnimationToOpenDialog()
    }

    override fun bindObservables() {}

    private fun setAnimationToOpenDialog() {
        dialog?.setOnShowListener {
            val view = dialog?.window?.decorView
            val displayMetrics = DisplayMetrics()
            activity?.windowManager?.defaultDisplay?.getMetrics(displayMetrics)
            val height = displayMetrics.heightPixels
            val width = displayMetrics.widthPixels
            val xPosition = height
            val yPosition = width
            val animator = ViewAnimationUtils.createCircularReveal(
                view, xPosition, yPosition,
                20f, view?.height?.toFloat() ?: 0f
            )
            animator?.duration = 300
            animator?.start()
        }
    }

    override fun initBinding() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
            executePendingBindings()
        }
    }
}
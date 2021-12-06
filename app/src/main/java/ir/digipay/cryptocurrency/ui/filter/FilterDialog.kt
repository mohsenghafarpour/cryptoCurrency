package ir.digipay.cryptocurrency.ui.filter

import android.util.DisplayMetrics
import android.view.ViewAnimationUtils
import androidx.core.view.forEach
import androidx.fragment.app.activityViewModels
import com.google.android.material.chip.Chip
import ir.digipay.cryptocurrency.R
import ir.digipay.cryptocurrency.base.BaseDialogFragment
import ir.digipay.cryptocurrency.databinding.DialogFilterBinding
import ir.digipay.cryptocurrency.ui.main.MainViewModel

class FilterDialog : BaseDialogFragment<MainViewModel, DialogFilterBinding>() {

    override val viewModel: MainViewModel by activityViewModels()

    override val layoutRes: Int = R.layout.dialog_filter

    override fun config() {
        setAnimationToOpenDialog()
        doneClicked()
    }

    override fun bindObservables() {}

    override fun initBinding() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
            executePendingBindings()
        }
    }

    private fun doneClicked() {
        binding?.fabDone?.setOnClickListener {
            checkingSort()
            checkingSortDir()
            dialog?.dismiss()
        }
    }

    private fun checkingSort() {
        binding?.chGroupSortBy?.forEach { chip ->
            if ((chip as Chip).isChecked) {
                viewModel.sortValue.value = chip.text.toString().lowercase()
                changeValueToApiKey(chip.text.toString())
            }
        }
    }

    private fun checkingSortDir() {
        binding?.chGroupSortDirection?.forEach { chip ->
            if ((chip as Chip).isChecked) {
                viewModel.sortDirValue.value = chip.text.toString().lowercase()
                changeValueToApiKey(chip.text.toString())
            }
        }
    }

    private fun changeValueToApiKey(value: String): String {
        return when (value) {
            "Ascending" -> "asc"
            "Descending" -> "desc"
            "Price" -> "price"
            else -> "name"
        }
    }

    private fun setAnimationToOpenDialog() {
        dialog?.setOnShowListener {
            val view = dialog?.window?.decorView
            val displayMetrics = DisplayMetrics()
            activity?.windowManager?.defaultDisplay?.getMetrics(displayMetrics)
            val height = displayMetrics.heightPixels
            val width = displayMetrics.widthPixels
            val animator = ViewAnimationUtils.createCircularReveal(
                view, height, width,
                20f, view?.height?.toFloat() ?: 0f
            )
            animator?.duration = 300
            animator?.start()
        }
    }
}
package ir.digipay.cryptocurrency.ui.filter

import android.util.DisplayMetrics
import android.view.ViewAnimationUtils
import androidx.fragment.app.activityViewModels
import com.google.android.material.chip.Chip
import ir.digipay.cryptocurrency.R
import ir.digipay.cryptocurrency.base.BaseDialogFragment
import ir.digipay.cryptocurrency.databinding.DialogFilterBinding
import ir.digipay.cryptocurrency.ui.main.MainViewModel
import ir.digipay.cryptocurrency.utils.QueryParams

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
            val queryParamsBuilder = QueryParams.Builder()
            val sortCriteria = getSortCriteria()
            if (sortCriteria != null)
                queryParamsBuilder.addSort(sortCriteria)
            val sortDirCriteria = getSortDirCriteria()
            if (sortDirCriteria != null)
                queryParamsBuilder.addSortDir(sortDirCriteria)
            viewModel.queryParams.value = queryParamsBuilder.build()
            dialog?.dismiss()
        }
    }

    private fun getSortCriteria(): String? {
        val checkedChipId = binding?.chGroupSortBy?.checkedChipId
        if (checkedChipId != null) {
            val checkedChipValue =
                binding?.chGroupSortBy?.findViewById<Chip>(checkedChipId)?.text?.toString()
            return translate(checkedChipValue)
        }
        return null
    }

    private fun getSortDirCriteria(): String? {
        val checkedChipId = binding?.chGroupSortDirection?.checkedChipId
        if (checkedChipId != null) {
            val checkedChipValue =
                binding?.chGroupSortDirection?.findViewById<Chip>(checkedChipId)?.text?.toString()
            return translate(checkedChipValue)
        }
        return null
    }

    private fun translate(value: String?): String? {
        return when (value) {
            context?.getString(R.string.label_ascending) -> "asc"
            context?.getString(R.string.label_descending) -> "desc"
            context?.getString(R.string.label_price) -> "price"
            context?.getString(R.string.label_name) -> "name"
            context?.getString(R.string.label_market_cap) -> "market_cap"
            context?.getString(R.string.label_circulating_supply) -> "circulating_supply"
            else -> value
        }
    }

    // TODO: 12/7/21 change default display
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
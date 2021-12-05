package ir.digipay.cryptocurrency.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import ir.digipay.cryptocurrency.R

abstract class BaseDialogFragment<VM : BaseViewModel, DB : ViewDataBinding> :
    DialogFragment() {

    abstract val viewModel: VM
    open var binding: DB? = null

    var flContainer: FrameLayout? = null

    private fun init(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
    }

    abstract val layoutRes: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val parentLayout = inflater.inflate(R.layout.base_dialog_fragment_box, container, false)
        flContainer = parentLayout?.findViewById(R.id.fl_container)
        // Add the container layout just like include in xml
        init(inflater, container)
        initBinding()
        val child = binding?.root ?: View(context)
        flContainer?.addView(child)
        bindObservables()
        return parentLayout
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        config()
    }

    abstract fun config()

    abstract fun bindObservables()

    abstract fun initBinding()

    override fun getTheme(): Int = R.style.full_screen_dialog

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}
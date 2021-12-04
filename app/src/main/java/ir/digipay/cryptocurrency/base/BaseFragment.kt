package ir.digipay.cryptocurrency.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding> : Fragment() {

    abstract val viewModel: VM
    open var binding: DB? = null

    private fun init(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
    }

    abstract val layoutRes: Int

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        init(inflater, container)
        initBinding()
        bindObservables()
        return binding?.root ?: View(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        config()
    }

    abstract fun config()
    abstract fun bindObservables()
    abstract fun initBinding()
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

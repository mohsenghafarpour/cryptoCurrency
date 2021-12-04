package ir.digipay.cryptocurrency.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding> : AppCompatActivity() {

    abstract val viewModel: VM
    abstract val layoutRes: Int
    val binding by lazy {
        DataBindingUtil.setContentView(this, layoutRes) as DB
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        config()
        bindObservables()
    }

    abstract fun config()
    abstract fun bindObservables()
    abstract fun initBinding()

}
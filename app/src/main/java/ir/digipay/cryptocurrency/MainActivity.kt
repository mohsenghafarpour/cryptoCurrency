package ir.digipay.cryptocurrency

import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ir.digipay.cryptocurrency.base.BaseActivity
import ir.digipay.cryptocurrency.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val viewModel: MainViewModel by viewModels()

    override val layoutRes: Int = R.layout.activity_main

    override fun config() {}

    override fun bindObservables() {}

    override fun initBinding() {
        binding.apply {
            lifecycleOwner = this@MainActivity
            vm = viewModel
            executePendingBindings()
        }
    }
}
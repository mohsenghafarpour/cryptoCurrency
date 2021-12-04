package ir.digipay.cryptocurrency.ui.currencies

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ir.digipay.cryptocurrency.R
import ir.digipay.cryptocurrency.base.BaseFragment
import ir.digipay.cryptocurrency.databinding.FragmentCurrenciesBinding

@AndroidEntryPoint
class CurrenciesFragment : BaseFragment<CurrenciesViewModel, FragmentCurrenciesBinding>() {

    override val viewModel: CurrenciesViewModel by viewModels()

    override val layoutRes: Int = R.layout.fragment_currencies

    override fun config() {}

    override fun bindObservables() {}

    override fun initBinding() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
            executePendingBindings()
        }
    }
}
package ir.digipay.cryptocurrency.ui.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import ir.digipay.cryptocurrency.R
import ir.digipay.cryptocurrency.base.BaseFragment
import ir.digipay.cryptocurrency.databinding.FragmentCoinDetailsBinding

class CoinDetailsFragment : BaseFragment<CoinDetailsViewModel, FragmentCoinDetailsBinding>() {

    private val args: CoinDetailsFragmentArgs by navArgs()

    override val viewModel: CoinDetailsViewModel by viewModels()

    override val layoutRes: Int = R.layout.fragment_coin_details

    override fun config() {
        viewModel.setArgs(args.currency)
    }

    override fun bindObservables() {}

    override fun initBinding() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
            executePendingBindings()
        }
    }
}
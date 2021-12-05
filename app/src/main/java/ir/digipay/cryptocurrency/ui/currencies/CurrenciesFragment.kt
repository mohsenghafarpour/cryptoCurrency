package ir.digipay.cryptocurrency.ui.currencies

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.digipay.cryptocurrency.R
import ir.digipay.cryptocurrency.base.BaseFragment
import ir.digipay.cryptocurrency.databinding.FragmentCurrenciesBinding
import ir.digipay.cryptocurrency.utils.EndlessRecyclerViewScrollListener

@AndroidEntryPoint
class CurrenciesFragment : BaseFragment<CurrenciesViewModel, FragmentCurrenciesBinding>() {

    override val viewModel: CurrenciesViewModel by viewModels()

    override val layoutRes: Int = R.layout.fragment_currencies

    override fun config() {
        viewModel.getData()
        onScrollListener()
        binding?.fabFilter?.setOnClickListener {
            findNavController().navigate(CurrenciesFragmentDirections.actionFragCurrenciesToDialogFilter())
        }
    }

    override fun bindObservables() {
        viewModel.currencies.observe(viewLifecycleOwner, {
            setAdapter(it)
        })
    }

    private fun setAdapter(data: List<Any>?) {
        (binding?.rvCurrencies?.adapter as? CurrenciesAdapter)?.submitList(data) ?: run {
            binding?.rvCurrencies?.adapter = CurrenciesAdapter().apply {
                submitList(data)
            }
        }
    }

    private fun onScrollListener() {
        binding?.rvCurrencies?.addOnScrollListener(object : EndlessRecyclerViewScrollListener() {
            override fun onLoadMore(page: Int) {
                viewModel.getNextPageData(page)
            }
        })
    }

    override fun initBinding() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
            executePendingBindings()
        }
    }
}
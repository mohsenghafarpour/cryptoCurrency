package ir.digipay.cryptocurrency.ui.currencies

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.digipay.cryptocurrency.R
import ir.digipay.cryptocurrency.base.BaseFragment
import ir.digipay.cryptocurrency.data.pojo.CurrencyModel
import ir.digipay.cryptocurrency.databinding.FragmentCurrenciesBinding
import ir.digipay.cryptocurrency.ui.main.MainViewModel
import ir.digipay.cryptocurrency.utils.EndlessRecyclerViewScrollListener

@AndroidEntryPoint
class CurrenciesFragment : BaseFragment<CurrenciesViewModel, FragmentCurrenciesBinding>() {

    private val sharedViewModel: MainViewModel by activityViewModels()

    override val viewModel: CurrenciesViewModel by viewModels()

    override val layoutRes: Int = R.layout.fragment_currencies

    override fun config() {
        binding?.cvNoData?.setOnRetryClickListener { viewModel.getData() }
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

        sharedViewModel.sortValue.observe(viewLifecycleOwner, {
//            viewModel.getData(sort = it.lowercase(), isFilter = true)
        })

        sharedViewModel.sortDirValue.observe(viewLifecycleOwner, {

        })

    }

    // TODO: 12/6/21 check notify data  set change
    private fun setAdapter(data: List<Any>?) {
        (binding?.rvCurrencies?.adapter as? CurrenciesAdapter)?.apply {
            submitList(data)
            notifyDataSetChanged()
        } ?: run {
            binding?.rvCurrencies?.adapter = CurrenciesAdapter(::navigateToDetail).apply {
                submitList(data)
            }
        }
    }

    private fun navigateToDetail(data: CurrencyModel) {
        findNavController().navigate(
            CurrenciesFragmentDirections.actionFragCurrenciesToFragCoinDetails(
                data
            )
        )
    }

    private fun onScrollListener() {
        binding?.rvCurrencies?.addOnScrollListener(object : EndlessRecyclerViewScrollListener() {
            override fun onLoadMore(start: Int) {
                viewModel.getData(start)
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
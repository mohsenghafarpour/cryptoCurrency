package ir.digipay.cryptocurrency.ui.currencies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ir.digipay.cryptocurrency.R
import ir.digipay.cryptocurrency.databinding.ItemCurrencyBinding
import ir.digipay.cryptocurrency.model.Currency
import ir.digipay.cryptocurrency.ui.currencies.vh.CurrencyVH
import ir.digipay.cryptocurrency.utils.AdapterItemAnimator

class CurrenciesAdapter() : ListAdapter<Any, RecyclerView.ViewHolder>(CurrencyDiffUtil),
    AdapterItemAnimator {

    private var previousPosition = 0

    override fun getItemViewType(position: Int): Int {
        return when (currentList[position]) {
            is Currency -> R.layout.item_currency
            else -> throw RuntimeException("unknown item type of ${currentList::class.java.simpleName} in ${this::class.java.name}")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            R.layout.item_currency -> CurrencyVH(
                ItemCurrencyBinding.inflate(inflater, parent, false)
            )
            else -> throw IllegalArgumentException("invalid item with view type $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = currentList[position]
        when (holder) {
            is CurrencyVH -> holder.bind(item as Currency)
        }
        previousPosition = animateItem(previousPosition, position, holder)
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.clearAnimation()
    }

}
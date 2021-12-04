package ir.digipay.cryptocurrency.ui.currencies

import androidx.recyclerview.widget.DiffUtil
import ir.digipay.cryptocurrency.model.CoinMarketCapResult

object CurrencyDiffUtil : DiffUtil.ItemCallback<Any>() {

    override fun areItemsTheSame(oldItem: Any, newItem: Any) = when (oldItem) {
        is CoinMarketCapResult -> newItem == oldItem
        else -> throw RuntimeException("unknown item type of ${oldItem::class.java.simpleName} in ${this::class.java.name}")
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any) = when (oldItem) {
        is CoinMarketCapResult -> oldItem.equalsContent(oldItem)
        else -> throw RuntimeException("unknown item type of ${oldItem::class.java.simpleName} in ${this::class.java.name}")
    }
}
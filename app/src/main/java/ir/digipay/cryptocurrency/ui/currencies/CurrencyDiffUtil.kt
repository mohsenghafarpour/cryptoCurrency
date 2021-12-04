package ir.digipay.cryptocurrency.ui.currencies

import androidx.recyclerview.widget.DiffUtil
import ir.digipay.cryptocurrency.model.CoinMarketCapResult
import ir.digipay.cryptocurrency.model.Header

object CurrencyDiffUtil : DiffUtil.ItemCallback<Any>() {

    override fun areItemsTheSame(oldItem: Any, newItem: Any) = when (oldItem) {
        is CoinMarketCapResult -> newItem == oldItem
        is Header -> newItem == oldItem
        else -> throw RuntimeException("unknown item type of ${oldItem::class.java.simpleName} in ${this::class.java.name}")
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any) = when (oldItem) {
        is Header -> (newItem is Header) && newItem as Header == oldItem as Header
        is CoinMarketCapResult -> oldItem.equalsContent(oldItem)
        else -> throw RuntimeException("unknown item type of ${oldItem::class.java.simpleName} in ${this::class.java.name}")
    }
}
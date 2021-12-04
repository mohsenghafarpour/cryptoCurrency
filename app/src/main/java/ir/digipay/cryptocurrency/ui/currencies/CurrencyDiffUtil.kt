package ir.digipay.cryptocurrency.ui.currencies

import androidx.recyclerview.widget.DiffUtil
import ir.digipay.cryptocurrency.model.CoinMarketCapResult
import ir.digipay.cryptocurrency.model.Title

object CurrencyDiffUtil : DiffUtil.ItemCallback<Any>() {

    override fun areItemsTheSame(oldItem: Any, newItem: Any) = when (oldItem) {
        is CoinMarketCapResult -> newItem == oldItem
        is Title -> newItem == oldItem
        else -> throw RuntimeException("unknown item type of ${oldItem::class.java.simpleName} in ${this::class.java.name}")
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any) = when (oldItem) {
        is Title -> (newItem is Title) && newItem as Title == oldItem as Title
        is CoinMarketCapResult -> oldItem.equalsContent(oldItem)
        else -> throw RuntimeException("unknown item type of ${oldItem::class.java.simpleName} in ${this::class.java.name}")
    }
}
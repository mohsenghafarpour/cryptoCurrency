package ir.digipay.cryptocurrency.ui.currencies

import androidx.recyclerview.widget.DiffUtil
import ir.digipay.cryptocurrency.model.Currency
import ir.digipay.cryptocurrency.model.Header

object CurrencyDiffUtil : DiffUtil.ItemCallback<Any>() {

    override fun areItemsTheSame(oldItem: Any, newItem: Any) = when (oldItem) {
        is Header -> newItem is Header
        is Currency -> newItem == oldItem
        else -> throw IllegalArgumentException("unknown item type of ${oldItem::class.java.simpleName} in ${this::class.java.name}")
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any) = when (oldItem) {
        is Header -> newItem is Header
        is Currency -> oldItem.equalsContent(oldItem)
        else -> throw IllegalArgumentException("unknown item type of ${oldItem::class.java.simpleName} in ${this::class.java.name}")
    }
}
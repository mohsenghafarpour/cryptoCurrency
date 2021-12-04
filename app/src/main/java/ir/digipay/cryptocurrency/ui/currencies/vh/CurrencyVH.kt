package ir.digipay.cryptocurrency.ui.currencies.vh

import androidx.recyclerview.widget.RecyclerView
import ir.digipay.cryptocurrency.BR
import ir.digipay.cryptocurrency.databinding.ItemCurrencyBinding
import ir.digipay.cryptocurrency.model.Currency

class CurrencyVH(private val binding: ItemCurrencyBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: Currency) {
        binding.apply {
            setVariable(BR.item, data)
            executePendingBindings()
        }
    }
}
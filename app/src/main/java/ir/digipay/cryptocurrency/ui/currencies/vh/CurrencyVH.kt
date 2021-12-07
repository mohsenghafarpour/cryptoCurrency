package ir.digipay.cryptocurrency.ui.currencies.vh

import androidx.recyclerview.widget.RecyclerView
import ir.digipay.cryptocurrency.BR
import ir.digipay.cryptocurrency.model.CurrencyModel
import ir.digipay.cryptocurrency.databinding.ItemCurrencyBinding

class CurrencyVH(
    private val binding: ItemCurrencyBinding,
    private val onItemClickDelegate: (CurrencyModel) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: CurrencyModel) {
        binding.apply {
            setVariable(BR.item, data)
            root.setOnClickListener { onItemClickDelegate.invoke(data) }
            executePendingBindings()
        }
    }
}
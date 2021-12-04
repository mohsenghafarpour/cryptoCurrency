package ir.digipay.cryptocurrency.ui.currencies.vh

import androidx.recyclerview.widget.RecyclerView
import ir.digipay.cryptocurrency.BR
import ir.digipay.cryptocurrency.databinding.ItemHeaderBinding
import ir.digipay.cryptocurrency.model.Header

class HeaderVH(private val binding: ItemHeaderBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: Header) {
        binding.apply {
            setVariable(BR.item, data)
            executePendingBindings()
        }
    }
}
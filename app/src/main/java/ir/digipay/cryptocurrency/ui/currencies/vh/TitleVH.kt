package ir.digipay.cryptocurrency.ui.currencies.vh

import androidx.recyclerview.widget.RecyclerView
import ir.digipay.cryptocurrency.BR
import ir.digipay.cryptocurrency.databinding.ItemTitleBinding
import ir.digipay.cryptocurrency.model.Title

class TitleVH(private val binding: ItemTitleBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: Title) {
        binding.apply {
            setVariable(BR.item, data)
            executePendingBindings()
        }
    }
}
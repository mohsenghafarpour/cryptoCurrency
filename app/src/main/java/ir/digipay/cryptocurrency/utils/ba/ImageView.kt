package ir.digipay.cryptocurrency.utils.ba

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import ir.digipay.cryptocurrency.utils.ktx.load

@BindingAdapter("loadImage")
fun ImageView.imageUrl(url: String?) {
    load(url)
}

package ir.digipay.cryptocurrency.utils.ba

import android.widget.TextView
import androidx.core.text.buildSpannedString
import androidx.core.text.color
import androidx.databinding.BindingAdapter
import ir.digipay.cryptocurrency.R
import ir.digipay.cryptocurrency.utils.ktx.getColorCompat
import ir.digipay.cryptocurrency.utils.ktx.isNegative
import ir.digipay.cryptocurrency.utils.ktx.round

@BindingAdapter("price")
fun TextView.formatPrice(price: Double) {
    text = "${price.round(4)}$"
}

@BindingAdapter("percentChange")
fun TextView.formatPercentChange(percentChange: Double) {
    val roundedPercent = percentChange.round(2)
    val a = buildSpannedString {
        color(context.getColorCompat(R.color.black)) { append("24h :") }
        color(
            if (roundedPercent.isNegative()) context.getColorCompat(R.color.red500)
            else context.getColorCompat(R.color.green500)
        ) {
            append(" ")
            append("$roundedPercent%")
        }
    }
    text = a
}

@BindingAdapter("capMarket")
fun TextView.formatMarketCap(marketCap: Double) {
    text = "marketCap ${marketCap.round(4)}"
}
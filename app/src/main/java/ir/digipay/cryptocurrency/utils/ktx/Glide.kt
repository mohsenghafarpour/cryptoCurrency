package ir.digipay.cryptocurrency.utils.ktx

import android.widget.ImageView
import ir.digipay.cryptocurrency.GlideApp


fun ImageView.load(
    url: String?
) {
    val request =
        GlideApp.with(this)
            .load(url)

    request.into(this)
}
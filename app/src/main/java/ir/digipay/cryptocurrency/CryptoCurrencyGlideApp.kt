package ir.digipay.cryptocurrency

import android.content.Context
import android.util.Log
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

@GlideModule
class CryptoCurrencyGlideApp : AppGlideModule() {
    override fun applyOptions(context: Context, builder: GlideBuilder) {

        if (BuildConfig.DEBUG) builder.setLogLevel(Log.DEBUG)
    }
}
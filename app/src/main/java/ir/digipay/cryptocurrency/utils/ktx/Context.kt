package ir.digipay.cryptocurrency.utils.ktx

import android.content.Context
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

fun Context.getColorCompat(@ColorRes color: Int): Int = ContextCompat.getColor(this, color)
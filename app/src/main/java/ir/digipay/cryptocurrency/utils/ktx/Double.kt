package ir.digipay.cryptocurrency.utils.ktx

import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sign

fun Double.round(digits: Int): Double {
    val factor = 10.0.pow(digits.toDouble())
    return (this * factor).roundToInt() / factor
}

fun Double.isNegative(): Boolean = this.sign == -1.0
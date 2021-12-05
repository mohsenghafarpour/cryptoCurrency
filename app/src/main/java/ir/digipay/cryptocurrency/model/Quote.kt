package ir.digipay.cryptocurrency.model

import com.google.gson.annotations.SerializedName

data class Quote(@SerializedName("USD") val usd: UsdPrice) {
    override fun equals(other: Any?): Boolean {
        return other is Quote && other.usd == this.usd
    }

    override fun hashCode(): Int {
        return usd.hashCode()
    }
}

package ir.digipay.cryptocurrency.model

import com.google.gson.annotations.SerializedName

data class CoinMarketCapResult(
    @SerializedName("status") val status: Status,
    @SerializedName("data") val data: List<Currency>
) {

    override fun equals(other: Any?): Boolean {
        return other is CoinMarketCapResult
    }

    fun equalsContent(other: Any?): Boolean {
        return other == this && other is CoinMarketCapResult && other.status == this.status
    }

    override fun hashCode(): Int {
        var result = status.hashCode()
        result = 31 * result + data.hashCode()
        return result
    }
}

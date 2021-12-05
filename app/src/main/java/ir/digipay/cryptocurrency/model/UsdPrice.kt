package ir.digipay.cryptocurrency.model

import com.google.gson.annotations.SerializedName

data class UsdPrice(
    @SerializedName("price") val price: Double,
    @SerializedName("volume_24h") val volume24h: Double,
    @SerializedName("volume_change_24h") val volumeChange24h: Double,
    @SerializedName("percent_change_24h") val percentChange24h: Double,
    @SerializedName("market_cap") val marketCap: Double,
    @SerializedName("market_cap_dominance") val marketCapDominance: Double,
    @SerializedName("fully_diluted_market_cap") val fullyDilutedMarketCap: Double,
    @SerializedName("last_updated") val lastUpdated: String
) {
    override fun equals(other: Any?): Boolean {
        return other is UsdPrice &&
                other.price == this.price &&
                other.percentChange24h == this.percentChange24h &&
                other.marketCap == this.marketCap
    }

    override fun hashCode(): Int {
        var result = price.hashCode()
        result = 31 * result + percentChange24h.hashCode()
        result = 31 * result + marketCap.hashCode()
        return result
    }


}

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
)

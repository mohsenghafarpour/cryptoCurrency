package ir.digipay.cryptocurrency.model

import com.google.gson.annotations.SerializedName

data class Currency(
    @SerializedName("id") val id :Int,
    @SerializedName("name") val name :String,
    @SerializedName("symbol") val symbol : String,
    @SerializedName("num_market_pairs") val numMarketPairs : Int,
    @SerializedName("date_added") val dateAdded : String,
    @SerializedName("max_supply") val maxSupply : Double,
    @SerializedName("circulating_supply") val circulatingSupply : Double,
    @SerializedName("cmc_rank") val cmcRank : Int,
    @SerializedName("last_updated") val lastUpdated : String,
    @SerializedName("quote") val quote : Quote
)

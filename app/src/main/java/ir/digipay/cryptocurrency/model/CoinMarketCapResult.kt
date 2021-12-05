package ir.digipay.cryptocurrency.model

import com.google.gson.annotations.SerializedName

data class CoinMarketCapResult(
    @SerializedName("status") val status: Status,
    @SerializedName("data") val data: List<Currency>
)
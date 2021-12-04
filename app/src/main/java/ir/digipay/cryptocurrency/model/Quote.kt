package ir.digipay.cryptocurrency.model

import com.google.gson.annotations.SerializedName

data class Quote(@SerializedName("USD") val usd: UsdPrice)

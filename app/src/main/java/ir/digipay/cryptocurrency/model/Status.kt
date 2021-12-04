package ir.digipay.cryptocurrency.model

import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("timestamp") val timestamp : String,
    @SerializedName("error_code") val errorCode : Int,
    @SerializedName("error_message") val errorMessage : String?,
    @SerializedName("total_count") val totalCount : Int
)

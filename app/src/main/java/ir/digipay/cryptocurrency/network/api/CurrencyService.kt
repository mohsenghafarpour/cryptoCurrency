package ir.digipay.cryptocurrency.network.api

import ir.digipay.cryptocurrency.model.CoinMarketCapResult
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyService {

    @GET("/v1/cryptocurrency/listings/latest")
    suspend fun getCurrenciesData(@Query("limit")limit : Int = 20, @Query("CMC_PRO_API_KEY") apiKey: String = "d20cf8cb-c359-4a5e-8ca5-783a6beb90ca"): CoinMarketCapResult

}
package ir.digipay.cryptocurrency.network.api

import ir.digipay.cryptocurrency.model.CoinMarketCapResult
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface CurrencyService {

    @GET("/v1/cryptocurrency/listings/latest")
    suspend fun getCurrenciesData(
        @QueryMap queryParams: Map<String, String>
    ): CoinMarketCapResult

}
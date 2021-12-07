package ir.digipay.cryptocurrency.repository

import ir.digipay.cryptocurrency.model.CoinMarketCapResult
import ir.digipay.cryptocurrency.network.ResultCall
import ir.digipay.cryptocurrency.utils.QueryParams

interface CurrenciesRepository {

    suspend fun getCurrencies(queryParams: QueryParams): ResultCall<CoinMarketCapResult>

}
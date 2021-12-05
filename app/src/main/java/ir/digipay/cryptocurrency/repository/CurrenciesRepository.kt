package ir.digipay.cryptocurrency.repository

import ir.digipay.cryptocurrency.model.CoinMarketCapResult
import ir.digipay.cryptocurrency.network.ResultCall

interface CurrenciesRepository {

    suspend fun getCurrencies(page: Int): ResultCall<CoinMarketCapResult>

}
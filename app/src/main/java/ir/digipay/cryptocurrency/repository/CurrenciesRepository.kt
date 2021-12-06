package ir.digipay.cryptocurrency.repository

import ir.digipay.cryptocurrency.data.pojo.CurrencyModel
import ir.digipay.cryptocurrency.model.CoinMarketCapResult
import ir.digipay.cryptocurrency.network.ResultCall

interface CurrenciesRepository {

    suspend fun getCurrencies(start: Int, sort: String): ResultCall<CoinMarketCapResult>

    suspend fun fetchCurrencies(start: Int, limit: Int = 20): List<CurrencyModel>
}
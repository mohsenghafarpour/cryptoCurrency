package ir.digipay.cryptocurrency.repository

import ir.digipay.cryptocurrency.model.CoinMarketCapResult
import ir.digipay.cryptocurrency.network.ResultCall
import ir.digipay.cryptocurrency.network.api.CurrencyService
import ir.digipay.cryptocurrency.utils.safeApiCall

class CurrenciesRepositoryImpl(private val service : CurrencyService) : CurrenciesRepository{

    override suspend fun getCurrencies(): ResultCall<CoinMarketCapResult> = safeApiCall {
        val response = service.getCurrenciesData()
        return@safeApiCall ResultCall.Success(response)
    }
}
package ir.digipay.cryptocurrency.repository

import ir.digipay.cryptocurrency.data.CurrenciesDB
import ir.digipay.cryptocurrency.data.pojo.CurrencyModel
import ir.digipay.cryptocurrency.model.CoinMarketCapResult
import ir.digipay.cryptocurrency.network.ResultCall
import ir.digipay.cryptocurrency.network.api.CurrencyService
import ir.digipay.cryptocurrency.utils.QueryParams
import ir.digipay.cryptocurrency.utils.safeApiCall
import javax.inject.Inject

class CurrenciesRepositoryImpl @Inject constructor(
    private val service: CurrencyService,
    private val currenciesDB: CurrenciesDB
) : CurrenciesRepository {

    override suspend fun getCurrencies(queryParams: QueryParams): ResultCall<CoinMarketCapResult> =
        safeApiCall {
            val response = service.getCurrenciesData(queryParams.data)
            return@safeApiCall ResultCall.Success(response)
        }

    override suspend fun fetchCurrencies(start: Int, limit: Int): List<CurrencyModel> =
        currenciesDB.currenciesDao().getCurrencies(start, limit)
}
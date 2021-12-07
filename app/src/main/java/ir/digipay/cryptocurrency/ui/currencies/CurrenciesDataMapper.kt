package ir.digipay.cryptocurrency.ui.currencies

import ir.digipay.cryptocurrency.model.Currency
import ir.digipay.cryptocurrency.model.CurrencyModel
import ir.digipay.cryptocurrency.model.Header

class CurrenciesDataMapper {

    fun map(data: List<Currency>, cacheData: List<Any>): MutableList<Any> {
        val items = mutableListOf(*cacheData.toTypedArray())
        if (items.isNullOrEmpty()) items.add(Header())
        val newMappedUniqueData = data.map { currency ->
            CurrencyModel(
                id = currency.id,
                name = currency.name,
                symbol = currency.symbol,
                price = currency.quote.usd.price,
                marketCap = currency.quote.usd.marketCap,
                icon = null,
                percentChange = currency.quote.usd.percentChange24h,
                sortOrder = 0
            )
        }.filter { !items.contains(it) }
        if (newMappedUniqueData.isNotEmpty())
            items.addAll(newMappedUniqueData)
        return items
    }
}
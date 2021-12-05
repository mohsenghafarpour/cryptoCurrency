package ir.digipay.cryptocurrency.ui.currencies

import ir.digipay.cryptocurrency.model.Header

class CurrenciesDataMapper {

    fun map(data: List<Any>, cacheData: List<Any>): MutableList<Any> {
        val items = mutableListOf(*cacheData.toTypedArray())
        if (items.isNullOrEmpty()) items.add(Header())
        items.addAll(data)
        return items
    }
}
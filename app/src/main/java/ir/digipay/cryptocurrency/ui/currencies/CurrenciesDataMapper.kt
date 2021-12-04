package ir.digipay.cryptocurrency.ui.currencies

import ir.digipay.cryptocurrency.model.Header

class CurrenciesDataMapper {

    fun map(data: List<Any>): List<Any> {
        val items = mutableListOf<Any>()
        items.add(Header("Coin Market Caps"))
        items.addAll(data)
        return items
    }
}
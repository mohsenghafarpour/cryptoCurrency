package ir.digipay.cryptocurrency.ui.currencies

import ir.digipay.cryptocurrency.model.Title

class CurrenciesDataMapper {

    fun map(data: List<Any>): List<Any> {
        val items = mutableListOf<Any>()
        items.add(Title("Symbol", "Currency Name", "Value"))
        items.addAll(data)
        return items
    }
}
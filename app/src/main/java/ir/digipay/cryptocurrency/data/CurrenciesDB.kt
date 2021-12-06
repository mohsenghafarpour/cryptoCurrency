package ir.digipay.cryptocurrency.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.digipay.cryptocurrency.data.pojo.CurrencyModel

@Database(
    entities = [
        CurrencyModel::class
    ], version = 1, exportSchema = false
)

abstract class CurrenciesDB : RoomDatabase() {
    abstract fun currenciesDao(): CurrenciesDao
}
package ir.digipay.cryptocurrency.data

import androidx.room.*
import ir.digipay.cryptocurrency.data.pojo.CurrencyModel

@Dao
interface CurrenciesDao {

    @Query("SELECT * FROM currency ORDER BY sortOrder LIMIT :limit OFFSET :start")
    suspend fun getCurrencies(start: Int, limit: Int): List<CurrencyModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertCurrencies(vararg currency: CurrencyModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(vararg currency: CurrencyModel)

    @Query("DELETE FROM currency")
    suspend fun clearCurrencies()
}
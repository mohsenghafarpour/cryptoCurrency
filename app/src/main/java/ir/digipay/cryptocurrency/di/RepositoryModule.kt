package ir.digipay.cryptocurrency.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.digipay.cryptocurrency.network.api.CurrencyService
import ir.digipay.cryptocurrency.repository.CurrenciesRepository
import ir.digipay.cryptocurrency.repository.CurrenciesRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun currenciesRepository(service: CurrencyService): CurrenciesRepository {
        return CurrenciesRepositoryImpl(service)
    }
}
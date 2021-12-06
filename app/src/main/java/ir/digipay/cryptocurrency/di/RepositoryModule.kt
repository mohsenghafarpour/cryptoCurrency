package ir.digipay.cryptocurrency.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import ir.digipay.cryptocurrency.data.CurrenciesDB
import ir.digipay.cryptocurrency.network.api.CurrencyService
import ir.digipay.cryptocurrency.repository.CurrenciesRepository
import ir.digipay.cryptocurrency.repository.CurrenciesRepositoryImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun currenciesRepository(
        service: CurrencyService,
        currenciesDB: CurrenciesDB
    ): CurrenciesRepository {
        return CurrenciesRepositoryImpl(service, currenciesDB)
    }
}
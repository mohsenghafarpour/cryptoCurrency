package ir.digipay.cryptocurrency.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import ir.digipay.cryptocurrency.ui.currencies.CurrenciesDataMapper
import javax.inject.Singleton

@Module
@InstallIn(ActivityRetainedComponent::class)
object CurrencyModule {

    @Provides
    @ActivityRetainedScoped
    fun provideCurrencyDataMapper(): CurrenciesDataMapper {
        return CurrenciesDataMapper()
    }
}
package ir.digipay.cryptocurrency.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import ir.digipay.cryptocurrency.data.CurrenciesDB

@Module
@InstallIn(ActivityRetainedComponent::class)
object AppModule {

    @Provides
    @ActivityRetainedScoped
    fun provideCurrenciesDataBase(@ApplicationContext context: Context): CurrenciesDB {
        return Room.databaseBuilder(context, CurrenciesDB::class.java, "currency").build()
    }
}
package com.example.exchangeapp.di

import android.content.Context
import androidx.room.Room
import com.example.exchangeapp.data.remote.ExchangeService
import com.example.exchangeapp.data.room.FavoriteCurrencyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideExchangeService(): ExchangeService {
        return Retrofit.Builder()
            .baseUrl(ExchangeService.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ExchangeService::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext applicationContext: Context): FavoriteCurrencyDatabase =
        Room.databaseBuilder(
            applicationContext,
            FavoriteCurrencyDatabase::class.java,
            "favorite_currency_database"
        ).createFromAsset("favorite_currency_database.db").build()
}
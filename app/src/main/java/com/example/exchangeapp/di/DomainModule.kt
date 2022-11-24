package com.example.exchangeapp.di

import com.example.exchangeapp.data.remote.ExchangeService
import com.example.exchangeapp.data.repository.ExchangeRepositoryImpl
import com.example.exchangeapp.data.room.FavoriteCurrencyDatabase
import com.example.exchangeapp.domain.repository.ExchangeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    @Singleton
    fun provideExchangeRepository(service: ExchangeService, database: FavoriteCurrencyDatabase): ExchangeRepository {
        return ExchangeRepositoryImpl(service, database)
    }
}
package com.example.exchangeapp.domain.repository

import com.example.exchangeapp.data.room.FavoriteCurrency
import com.example.exchangeapp.domain.model.Currency
import com.example.exchangeapp.domain.model.ExchangeCurrency
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ExchangeRepository {
    suspend fun getExchangeCurrency(from: String): ExchangeCurrency?
    suspend fun getFavoriteCurrencies(): Flow<List<FavoriteCurrency>>
    suspend fun getFavoriteCurrencyByCode(code: String): Flow<FavoriteCurrency>
    suspend fun updateFavoriteCurrency(currency: Currency)
}
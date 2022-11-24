package com.example.exchangeapp.data.repository

import com.example.exchangeapp.data.remote.ExchangeService
import com.example.exchangeapp.data.room.FavoriteCurrency
import com.example.exchangeapp.data.room.FavoriteCurrencyDatabase
import com.example.exchangeapp.domain.model.Currency
import com.example.exchangeapp.domain.model.ExchangeCurrency
import com.example.exchangeapp.domain.model.Results
import com.example.exchangeapp.domain.repository.ExchangeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExchangeRepositoryImpl @Inject constructor(
    private val exchangeService: ExchangeService,
    favoriteCurrencyDatabase: FavoriteCurrencyDatabase
) : ExchangeRepository {
    private val favoriteCurrencyDao = favoriteCurrencyDatabase.favoriteCurrencyDao()

    override suspend fun getExchangeCurrency(from: String): ExchangeCurrency {
        return if (exchangeService.getExchangeCurrency(from).isSuccessful) {
            exchangeService.getExchangeCurrency(from).body()!!
        } else ExchangeCurrency(results = Results())
    }

    override suspend fun getFavoriteCurrencies(): Flow<List<FavoriteCurrency>> {
        return favoriteCurrencyDao.getFavoriteCurrencies()
    }

    override suspend fun getFavoriteCurrencyByCode(code: String): Flow<FavoriteCurrency> {
        return favoriteCurrencyDao.getFavoriteCurrencyByCode(code)
    }

    override suspend fun updateFavoriteCurrency(currency: Currency) {
        favoriteCurrencyDao.updateFavoriteCurrency(
            FavoriteCurrency(
                currencyCode = currency.currencyCode,
                favorite = currency.favorite
            )
        )
    }
}
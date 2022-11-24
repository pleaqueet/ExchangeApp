package com.example.exchangeapp.domain.use_cases

import com.example.exchangeapp.data.room.FavoriteCurrency
import com.example.exchangeapp.domain.model.Currency
import com.example.exchangeapp.domain.model.Resource
import com.example.exchangeapp.domain.repository.ExchangeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetFavoriteCurrenciesUseCase @Inject constructor(
    private val repository: ExchangeRepository
) {
    suspend operator fun invoke(): Flow<List<FavoriteCurrency>> = repository.getFavoriteCurrencies()
    suspend fun getFavoriteCurrencyByCode(code: String) = repository.getFavoriteCurrencyByCode(code)
}
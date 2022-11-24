package com.example.exchangeapp.domain.use_cases

import com.example.exchangeapp.domain.model.Currency
import com.example.exchangeapp.domain.repository.ExchangeRepository
import javax.inject.Inject

class UpdateFavoriteCurrencyUseCase @Inject constructor(
    private val repository: ExchangeRepository
) {
    suspend operator fun invoke(currency: Currency) {
        repository.updateFavoriteCurrency(currency)
    }
}
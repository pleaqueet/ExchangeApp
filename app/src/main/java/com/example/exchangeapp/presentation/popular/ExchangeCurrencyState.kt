package com.example.exchangeapp.presentation.popular

import com.example.exchangeapp.domain.model.ExchangeCurrency

data class ExchangeCurrencyState(
    val isLoading: Boolean = false,
    val exchangeCurrencies: List<ExchangeCurrency> = emptyList(),
    val error: String = ""
)

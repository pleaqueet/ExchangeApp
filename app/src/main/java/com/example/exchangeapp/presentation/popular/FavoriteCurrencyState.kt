package com.example.exchangeapp.presentation.popular

import com.example.exchangeapp.data.room.FavoriteCurrency

data class FavoriteCurrencyState(
    val isLoading: Boolean = false,
    val favoriteCurrencies: List<FavoriteCurrency> = emptyList(),
    val error: String = ""
)
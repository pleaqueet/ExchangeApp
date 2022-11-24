package com.example.exchangeapp.domain.model

data class ExchangeCurrency(
    val base: String = "USD",
    val ms: Int = 0,
    val results: Results,
    val updated: String = ""
)
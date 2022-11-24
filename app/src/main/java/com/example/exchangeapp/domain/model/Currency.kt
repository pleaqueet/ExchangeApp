package com.example.exchangeapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Currency(
    @PrimaryKey
    val currencyCode: String,
    val exchangeRate: String,
    var favorite: Boolean = false
)
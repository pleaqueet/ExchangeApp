package com.example.exchangeapp.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteCurrency(
    @PrimaryKey
    val currencyCode: String,
    val favorite: Boolean = false
)
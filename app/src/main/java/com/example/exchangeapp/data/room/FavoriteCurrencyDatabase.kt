package com.example.exchangeapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoriteCurrency::class], version = 1)
abstract class FavoriteCurrencyDatabase : RoomDatabase() {
    abstract fun favoriteCurrencyDao(): FavoriteCurrencyDao
}
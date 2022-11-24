package com.example.exchangeapp.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.exchangeapp.domain.model.Currency
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteCurrencyDao {
    @Query("SELECT * FROM favoritecurrency")
    fun getFavoriteCurrencies(): Flow<List<FavoriteCurrency>>

    @Query("SELECT * FROM favoritecurrency WHERE currencyCode=:code")
    fun getFavoriteCurrencyByCode(code: String): Flow<FavoriteCurrency>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCurrency(favoriteCurrency: FavoriteCurrency)

    @Update(entity = FavoriteCurrency::class)
    suspend fun updateFavoriteCurrency(favoriteCurrency: FavoriteCurrency)
}
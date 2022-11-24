package com.example.exchangeapp.data.remote

import com.example.exchangeapp.domain.model.ExchangeCurrency
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeService {

    @GET("fetch-all?api_key=$API_KEY")
    suspend fun getExchangeCurrency(
        @Query("from") from: String
    ): Response<ExchangeCurrency>

    companion object {
        const val API_KEY = "9c2fe3b706-f79adb80aa-rlm0na"
        const val API_URL = "https://api.fastforex.io/"
    }
}
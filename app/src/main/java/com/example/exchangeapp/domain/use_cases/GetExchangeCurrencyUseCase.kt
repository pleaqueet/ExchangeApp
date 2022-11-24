package com.example.exchangeapp.domain.use_cases

import com.example.exchangeapp.domain.model.ExchangeCurrency
import com.example.exchangeapp.domain.model.Resource
import com.example.exchangeapp.domain.repository.ExchangeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetExchangeCurrencyUseCase @Inject constructor(
    private val repository: ExchangeRepository
) {
    operator fun invoke(
        from: String
    ): Flow<Resource<ExchangeCurrency>> = flow {
        try {
            emit(Resource.Loading())
            val exchangeCurrency = repository.getExchangeCurrency(from)
            emit(Resource.Success(exchangeCurrency))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}
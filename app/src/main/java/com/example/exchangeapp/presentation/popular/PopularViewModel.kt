package com.example.exchangeapp.presentation.popular

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exchangeapp.domain.model.Currency
import com.example.exchangeapp.domain.model.Resource
import com.example.exchangeapp.domain.use_cases.GetExchangeCurrencyUseCase
import com.example.exchangeapp.domain.use_cases.GetFavoriteCurrenciesUseCase
import com.example.exchangeapp.domain.use_cases.UpdateFavoriteCurrencyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularViewModel @Inject constructor(
    private val getExchangeCurrencyUseCase: GetExchangeCurrencyUseCase,
    private val getFavoriteCurrenciesUseCase: GetFavoriteCurrenciesUseCase,
    private val updateCurrencyUseCase: UpdateFavoriteCurrencyUseCase
) : ViewModel() {

    private val _sortingState = mutableStateOf(SortingState())
    val sortingState: State<SortingState> = _sortingState

    private val _exchangeCurrency = mutableStateOf(ExchangeCurrencyState())
    val exchangeCurrencyState: State<ExchangeCurrencyState> = _exchangeCurrency

    private val _favoriteCurrencyState = mutableStateOf(FavoriteCurrencyState())
    val favoriteCurrencyState: State<FavoriteCurrencyState> = _favoriteCurrencyState

    private val _selectedCurrency = mutableStateOf("USD")
    val selectedCurrency: State<String> = _selectedCurrency

    init {
        getExchangeCurrency()
        viewModelScope.launch {
            getFavoriteCurrency()
        }
    }

    fun setSortingState(state: SortingState) {
        _sortingState.value = state
    }

    fun updateFavoriteCurrency(currency: Currency) {
        viewModelScope.launch {
            updateCurrencyUseCase(currency)
        }
    }

    fun setFromExchangeCurrency(from: String) {
        _selectedCurrency.value = from
        viewModelScope.launch {
            getExchangeCurrency(from)
        }
    }

    private suspend fun getFavoriteCurrency() {
        getFavoriteCurrenciesUseCase().onEach { result ->
            if (result.isNotEmpty()) {
                _favoriteCurrencyState.value = FavoriteCurrencyState(favoriteCurrencies = result)
            } else {
                _favoriteCurrencyState.value = FavoriteCurrencyState(
                    error = "An unexpected error occurred"
                )
            }
        }.launchIn(viewModelScope)
    }

    private fun getExchangeCurrency(from: String = "USD") {
        getExchangeCurrencyUseCase(from).onEach { exchangeCurrency ->
            when (exchangeCurrency) {
                is Resource.Success -> {
                    val result = exchangeCurrency.data
                    _exchangeCurrency.value = ExchangeCurrencyState(
                        exchangeCurrencies = listOf(result!!)
                    )
                }
                is Resource.Error -> {
                    _exchangeCurrency.value = ExchangeCurrencyState(
                        error = exchangeCurrency.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _exchangeCurrency.value = ExchangeCurrencyState(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}
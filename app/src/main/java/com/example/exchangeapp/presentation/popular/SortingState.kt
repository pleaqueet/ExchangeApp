package com.example.exchangeapp.presentation.popular

data class SortingState(
    val sortingState: String = ALPHABET_ASC
) {
    companion object {
        const val ALPHABET_ASC = "alphabet_asc"
        const val ALPHABET_DESC = "alphabet_desc"
        const val RATE_ASC = "rate_asc"
        const val RATE_DESC = "rate_desc"
    }
}

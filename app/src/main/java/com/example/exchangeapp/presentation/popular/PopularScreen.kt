package com.example.exchangeapp.presentation.popular

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.exchangeapp.R
import com.example.exchangeapp.domain.model.Currency

@Composable
fun PopularScreen(
    onClick: () -> Unit,
    viewModel: PopularViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val exchangeCurrencyState = viewModel.exchangeCurrencyState.value
    val favoriteCurrencies = viewModel.favoriteCurrencyState.value.favoriteCurrencies
    val currencies = stringArrayResource(id = R.array.currencies)
    var expanded by remember { mutableStateOf(false) }
    val selectedText = viewModel.selectedCurrency.value
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(Modifier.padding(10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = selectedText,
                    onValueChange = { viewModel.setFromExchangeCurrency(it) },
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(3f)
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            textFieldSize = coordinates.size.toSize()
                        },
                    label = { Text("Currency") },
                    trailingIcon = {
                        Icon(icon, "contentDescription",
                            Modifier.clickable { expanded = !expanded })
                    }
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                ) {
                    currencies.forEach { currency ->
                        DropdownMenuItem(onClick = {
                            expanded = false
                            viewModel.setFromExchangeCurrency(currency)
                        }) {
                            Text(text = currency)
                        }
                    }
                }
                Button(
                    onClick = {
                        onClick()
                    },
                    content = {
                        Text(text = "Sort")
                    }
                )
            }

            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    exchangeCurrencyState.exchangeCurrencies.forEach { exchangeCurrency ->
                        var currentCurrencies = exchangeCurrency.results.currencies
                        items(currentCurrencies.size) { i ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        viewModel.updateFavoriteCurrency(
                                            exchangeCurrency.results.currencies[i].copy(
                                                favorite = !exchangeCurrency.results.currencies[i].favorite
                                            )
                                        )
                                    }
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = "${exchangeCurrency.results.currencies[i].currencyCode}: ${exchangeCurrency.results.currencies[i].exchangeRate}")
                                FavoriteButton(
                                    currency = exchangeCurrency.results.currencies[i],
                                    favorite = favoriteCurrencies[i].favorite
                                )
                            }
                        }
                    }
                }

                if (exchangeCurrencyState.error.isNotBlank()) {
                    Text(
                        text = exchangeCurrencyState.error,
                        color = MaterialTheme.colors.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .align(Alignment.Center)
                    )
                }
                if (exchangeCurrencyState.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    }
}

@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    viewModel: PopularViewModel = hiltViewModel(),
    favorite: Boolean,
    currency: Currency,
    color: Color = Color(0xffE91E63)
) {

    var isFavorite by remember { mutableStateOf(favorite) }

    IconToggleButton(
        checked = isFavorite,
        onCheckedChange = {
            isFavorite = !isFavorite
            viewModel.updateFavoriteCurrency(currency.copy(favorite = isFavorite))
        }
    ) {
        Icon(
            tint = color,
            modifier = modifier.graphicsLayer {
                scaleX = 1.3f
                scaleY = 1.3f
            },
            imageVector = if (isFavorite) {
                Icons.Filled.Favorite
            } else {
                Icons.Default.FavoriteBorder
            },
            contentDescription = null
        )
    }
}
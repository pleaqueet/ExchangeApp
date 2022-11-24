package com.example.exchangeapp.presentation.sorting

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.example.exchangeapp.presentation.BottomBarScreen
import com.example.exchangeapp.presentation.popular.SortingState

@Composable
fun SortingContent(
    navController: NavHostController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.clickable {
                navController.navigate(BottomBarScreen.Popular.route)
            },
            text = "По алфавиту(возрастание)",
            fontSize = MaterialTheme.typography.h6.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.clickable {
                navController.navigate(BottomBarScreen.Popular.route)
            },
            text = "По алфавиту(убывание)",
            fontSize = MaterialTheme.typography.h6.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.clickable {
                navController.navigate(BottomBarScreen.Popular.route)
            },
            text = "По значению(возрастание)",
            fontSize = MaterialTheme.typography.h6.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.clickable {
                navController.navigate(BottomBarScreen.Popular.route)
            },
            text = "По значению(убывание)",
            fontSize = MaterialTheme.typography.h6.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}
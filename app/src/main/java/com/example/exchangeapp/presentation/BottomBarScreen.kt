package com.example.exchangeapp.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Popular : BottomBarScreen(
        route = "popular",
        title = "Popular",
        icon = Icons.Default.Home
    )

    object Favorite : BottomBarScreen(
        route = "favorite",
        title = "Favorite",
        icon = Icons.Default.Favorite
    )
}

package com.example.exchangeapp.presentation.nav_graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.exchangeapp.presentation.sorting.SortingContent

fun NavGraphBuilder.sortingNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.SORTING,
        startDestination = SortingScreen.Sorting.route
    ) {
        composable(route = SortingScreen.Sorting.route) {
            SortingContent(navController = navController)
        }
    }
}

sealed class SortingScreen(val route: String) {
    object Sorting : SortingScreen(route = "SORTING")
}
package com.example.exchangeapp.presentation.nav_graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.exchangeapp.presentation.BottomBarScreen
import com.example.exchangeapp.presentation.favorite.FavoriteScreen
import com.example.exchangeapp.presentation.popular.PopularScreen

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Popular.route
    ) {
        sortingNavGraph(navController = navController)
        composable(route = BottomBarScreen.Popular.route) {
            PopularScreen(
                onClick = {
                    navController.navigate(Graph.SORTING)
                },
                navController = navController
            )
        }
        composable(route = BottomBarScreen.Favorite.route) {
            FavoriteScreen(
                onClick = {
                    navController.navigate(Graph.SORTING)
                }
            )
        }
    }
}

object Graph {
    const val MAIN = "main_graph"
    const val SORTING = "sorting_graph"
}
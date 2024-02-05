package com.tryden.breedly.ui.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.tryden.breedly.ui.screens.BreedsListScreen

/**
 * Composable responsible for the navigation inside of the Breedly app.
 */

@Composable
fun BreedlyNavigaiton(toggleTheme: () -> Unit) {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = Modifier
    ) {
        composable(route = Screen.Home.route) {
            BreedsListScreen(toggleTheme = toggleTheme, modifier = Modifier.fillMaxWidth())
        }
        composable(route = Screen.Details.route) {
            // todo
        }
        composable(route = Screen.Favorites.route) {
            // todo
        }

    }

}
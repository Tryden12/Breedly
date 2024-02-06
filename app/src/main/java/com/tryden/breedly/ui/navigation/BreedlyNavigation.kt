package com.tryden.breedly.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.tryden.breedly.ui.screens.BreedDetailsScreen
import com.tryden.breedly.ui.screens.BreedsListScreen

/**
 * Composable responsible for the navigation inside of the Breedly app.
 */

@Composable
fun BreedlyNavigaiton(
    toggleTheme: () -> Unit,
    paddingValues: PaddingValues
) {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = BreedlyScreen.Home.name,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(route = BreedlyScreen.Home.name) {
            BreedsListScreen(
                onDogBreedClicked = { dogBreedId ->
//                    todo: pass in breed id
                    navController.navigate(BreedlyScreen.Details.name)
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
        composable(route = BreedlyScreen.Details.name) {
            BreedDetailsScreen()
        }
        composable(route = BreedlyScreen.Favorites.name) {
            // todo
        }

    }

}
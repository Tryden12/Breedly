package com.tryden.breedly.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tryden.breedly.ui.screens.BreedDetailsScreen
import com.tryden.breedly.ui.screens.BreedsListScreen
import com.tryden.breedly.utils.Constants.BREED_ID_KEY

/**
 * Composable responsible for the navigation inside of the Breedly app.
 */

@Composable
fun BreedlyNavigation(
    toggleTheme: () -> Unit,
    paddingValues: PaddingValues
) {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(route = Screen.Home.route) {
            BreedsListScreen(
                onDogBreedClicked = { dogBreedId ->
                    navController.navigate( route = Screen.BreedDetails.createRoute(dogBreedId) )
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
        composable(
            route = Screen.BreedDetails.route,
            arguments = listOf(navArgument(BREED_ID_KEY) {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            val breedId: Int =
                backStackEntry.arguments?.getInt(BREED_ID_KEY) ?: -1
            BreedDetailsScreen(breedId = breedId)
        }
        composable(route = Screen.Favorites.route) {
            // todo
        }

    }

}
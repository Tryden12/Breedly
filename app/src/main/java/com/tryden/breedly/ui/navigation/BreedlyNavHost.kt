package com.tryden.breedly.ui.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.tryden.breedly.ui.app.BreedlyAppState
import com.tryden.breedly.ui.feature.breed_details.BreedDetailsScreen
import com.tryden.breedly.ui.feature.breed_favorites.FavoritesScreen
import com.tryden.breedly.ui.feature.breed_list.BreedsListScreen
import com.tryden.breedly.utils.Constants

/**
 * NavHost for the Breedly app.
 */
@Composable
fun BreedlyNavHost(
    appState: BreedlyAppState,
    modifier: Modifier = Modifier,
    startDestination: String = Screen.Home.route
) {
    val navController = appState.navController

    // Backstack
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route ?: startDestination

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
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
            arguments = listOf(navArgument(Constants.BREED_ID_KEY) {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            val breedId: Int =
                backStackEntry.arguments?.getInt(Constants.BREED_ID_KEY) ?: -1
            BreedDetailsScreen(
                breedId = breedId,
                currentScreenRoute = currentRoute,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
            )
        }
        composable(route = Screen.Favorites.route) {
            FavoritesScreen(onDogBreedClicked = {dogBreedId ->
                navController.navigate(route = Screen.Favorites.route)
            })
        }
    }
}
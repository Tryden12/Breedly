package com.tryden.breedly.ui.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
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
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Home.route,
) {
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
            arguments = listOf(navArgument(BREED_ID_KEY) {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            val breedId: Int =
                backStackEntry.arguments?.getInt(BREED_ID_KEY) ?: -1
            BreedDetailsScreen(
                breedId = breedId,
                currentScreenRoute = currentRoute,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
            )
        }
        composable(route = Screen.Favorites.route) {
            // todo
        }

    }

}
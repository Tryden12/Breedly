package com.tryden.breedly.ui

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tryden.breedly.ui.components.BreedlyAppBar
import com.tryden.breedly.ui.navigation.BreedlyNavigaiton
import com.tryden.breedly.ui.navigation.BreedlyScreen

/**
 * The first composable of the app to run, which puts everything in motion from MainActivity.
 **/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BreedlyApp(
    navController: NavHostController = rememberNavController(),
) {
    // Handle theme type: light or dark mode
    val currentTheme = isSystemInDarkTheme()
    val toggleTheme: () -> Unit = {
        setTheme(currentTheme)
    }

    // Backstack
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Current screen
    val currentScreen = BreedlyScreen.valueOf(
        backStackEntry?.destination?.route ?: BreedlyScreen.Home.name
    )

    Scaffold(
        topBar = {
            BreedlyAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        BreedlyNavigaiton(toggleTheme = toggleTheme, paddingValues = innerPadding)
    }
}

// Function for handling light/dark mode changes
private fun setTheme(currentTheme: Boolean) {
    if (currentTheme) {
        // set light mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    } else {
        // set dark mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }
}
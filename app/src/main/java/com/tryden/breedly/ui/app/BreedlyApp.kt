package com.tryden.breedly.ui.app

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import com.tryden.breedly.ui.common.BreedlyBottomBar
import com.tryden.breedly.ui.common.BreedlyDefaultTopAppBar
import com.tryden.breedly.ui.common.BreedsDetailsTopAppBar
import com.tryden.breedly.ui.common.BreedsListTopAppBar
import com.tryden.breedly.ui.common.FavoritesTopAppBar
import com.tryden.breedly.ui.navigation.BreedlyNavHost
import com.tryden.breedly.utils.Constants.BREEDS_LIST_ROUTE
import com.tryden.breedly.utils.Constants.BREED_DETAILS_ROUTE
import com.tryden.breedly.utils.Constants.FAVORITES_ROUTE

/**
 * Root composable for the Breedly app.
 */
@Composable
fun BreedlyApp(
    windowSizeClass: WindowSizeClass,
    appState: BreedlyAppState = rememberBreedlyAppState(windowSizeClass = windowSizeClass)
) {
    val destination = appState.currentTopLevelDestination
    val currentRoute = appState.currentRoute

    Scaffold(
        modifier = Modifier,
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets(0,0,0,0),
        topBar = {
                 when (appState.currentDestination?.route) {
                     BREEDS_LIST_ROUTE -> BreedsListTopAppBar(title = appState.currentDestinationName)
                     BREED_DETAILS_ROUTE -> {
                         BreedsDetailsTopAppBar(
                             title =  appState.currentDestinationName,
                             canNavigateBack = appState.canNavigateBack,
                             navigateUp = { appState.navigateUp() })
                     }
                     FAVORITES_ROUTE -> FavoritesTopAppBar(title = appState.currentDestinationName)
                     else -> BreedlyDefaultTopAppBar()
                 }
        },
        bottomBar = {
            if (appState.shouldShowBottomBar) {
                BreedlyBottomBar(
                    destinations = appState.topLevelDestinations,
                    onNavigateToDestination = appState::navigateToTopLevelDestination,
                    currentDestination = appState.currentDestination,
                    modifier = Modifier.testTag("BreedlyBottomBar")
                )
            }
        }
    ) { paddingValues ->
        Log.d("BreedlyApp", "BreedlyApp currentRoute = $currentRoute")
        Row(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .consumeWindowInsets(paddingValues)
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal)
                )
        ) {
//            if (appState.shouldShowNavRail) {
//                // todo: BreedlyNavRail()
//            }


            BreedlyNavHost(appState = appState)
        }
    }
}
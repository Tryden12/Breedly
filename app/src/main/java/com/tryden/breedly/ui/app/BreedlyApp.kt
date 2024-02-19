package com.tryden.breedly.ui.app

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
import com.tryden.breedly.ui.navigation.BreedlyNavHost

/**
 * Root composable for the Breedly app.
 */
@Composable
fun BreedlyApp(
    windowSizeClass: WindowSizeClass,
    appState: BreedlyAppState = rememberBreedlyAppState(windowSizeClass = windowSizeClass)
) {
    val destination = appState.currentTopLevelDestination

    Scaffold(
        modifier = Modifier,
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets(0,0,0,0),
        topBar = {
            // todo: adjust to accommodate breed details
//            when (destination) {
//                TopLevelDestination.BREEDS_LIST -> BreedsListTopAppBar()
//                else -> BreedsListTopAppBar()
//            }
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
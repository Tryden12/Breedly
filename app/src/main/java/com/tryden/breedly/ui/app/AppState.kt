package com.tryden.breedly.ui.app

import androidx.compose.runtime.Stable
import kotlinx.coroutines.CoroutineScope
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.tracing.trace
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.tryden.breedly.ui.navigation.Screen
import com.tryden.breedly.ui.navigation.TopLevelDestination
import com.tryden.breedly.ui.navigation.TopLevelDestination.*
import com.tryden.breedly.utils.Constants

/**
 * Breedly application state.
 *
 * Here we gather WindowSizeClass, NavController, Current Destination,
 * Bottom Bar type (normal or rail), and TopLevelDestinations.
 */

@Stable
class BreedlyAppState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
    val windowSizeClass: WindowSizeClass
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            Constants.HOME_ROUTE -> BREEDS_LIST
            Constants.FAVORITES_ROUTE -> FAVORITES
            else -> null
        }

    val shouldShowBottomBar: Boolean
        get() = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact

    // todo:
//    val shouldShowNavRail: Boolean
//        get() = !shouldShowNavRail

    /**
     * Map of top level destinations to be used in the TopBar, BottomBar and NavRail. The key is the
     * route.
     */
    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.entries

    /**
     * UI logic for navigating to a top level destination in the app. Top level destinations have
     * only one copy of the destination of the back stack, and save and restore state whenever you
     * navigate to and from it.
     *
     * @param topLevelDestination: The destination the app needs to navigate to.
     */
    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        trace("Navigation: ${topLevelDestination.name}") {
            val topLevelNavOptions = navOptions {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }

            when (topLevelDestination) {
                BREEDS_LIST -> navController.navigate(route = Screen.Home.route)
                FAVORITES -> navController.navigate(route = Screen.Favorites.route)
            }
        }

    }
}

@Composable
fun rememberBreedlyAppState(
    windowSizeClass: WindowSizeClass,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
) : BreedlyAppState {
    return remember(
        navController,
        coroutineScope,
        windowSizeClass
    ) {
        BreedlyAppState(
            navController,
            coroutineScope,
            windowSizeClass
        )
    }
}
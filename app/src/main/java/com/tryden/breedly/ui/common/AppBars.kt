package com.tryden.breedly.ui.common

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.tryden.breedly.R
import com.tryden.breedly.ui.navigation.Screen
import com.tryden.breedly.ui.navigation.TopLevelDestination

/**
 * Composables that display either bottom or top app bar.
 */


/**
 * Bottom navigation bar with content slot. Wraps Material 3 [NavigationBar].
 *
 * @param modifier Modifier to be applied to the navigation bar.
 * @param content Destinations inside the navigation bar. This should contain multiple
 * [NavigationBarItem]s.
 */
@Composable
fun BreedlyBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier
) {
    BreedlyNavigationBar(modifier = modifier) {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            BreedlyNavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    Icon(
                        imageVector = destination.unselectedIcon, contentDescription = null
                    )
                },
                selectedIcon = {
                    Icon(
                        imageVector = destination.selectedIcon, contentDescription = null
                    )
                },
                label = { Text(text = destination.iconTextId) },
            )
        }
    }
}

/** Top bar for BreedsListScreen **/
@Composable
fun BreedsListTopAppBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name)) },
        actions = {
            // todo actions: search, filter, sort
        },
        backgroundColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground,
        elevation = 0.dp,
        modifier = modifier.fillMaxWidth()
    )
}


/** Top bar for BreedsDetailsScreen **/
@Composable
fun BreedsDetailsTopAppBar(
    currentScreenRoute: String?,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    Log.d("BreedlyAppBar", "currentScreenRoute: $currentScreenRoute")
    var currentScreenName = stringResource(id = R.string.app_name)
    if (!currentScreenRoute.isNullOrEmpty()) {
        currentScreenName = if (Screen.BreedDetails.route == currentScreenRoute) {
            stringResource(Screen.BreedDetails.resourceId)
        } else {
            stringResource(id = R.string.app_name)
        }
    }
    Log.d("BreedlyAppBar", "currentScreenName: $currentScreenName")

    TopAppBar(
        title = { Text(text = currentScreenName) },
        backgroundColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
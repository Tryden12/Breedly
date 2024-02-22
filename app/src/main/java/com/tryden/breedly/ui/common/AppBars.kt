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
import com.tryden.breedly.ui.navigation.TopLevelDestination
import com.tryden.breedly.utils.Constants

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

/**
 * Default top bar for Breedly app.
 * This is used in place of other app bars to just display the app name as title.
 */
@Composable
fun BreedlyDefaultTopAppBar(modifier: Modifier = Modifier) {
    Log.d("TopAppBar", "BreedlyDefaultTopAppBar used")
    TopAppBar(
        title = { Text(text = Constants.APP_NAME) },
        backgroundColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
        elevation = 0.dp,
        modifier = modifier.fillMaxWidth()
    )
}

/** Top bar for BreedsListScreen **/
@Composable
fun BreedsListTopAppBar(
    title: String,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = title) },
        actions = {
            // todo actions: search, filter, sort
        },
        backgroundColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
        elevation = 0.dp,
        modifier = modifier.fillMaxWidth()
    )
}

/** Top bar for FavoritesScreen **/
@Composable
fun FavoritesTopAppBar(
    title: String,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = title) },
        actions = {
            // todo actions: edit
        },
        backgroundColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
        elevation = 0.dp,
        modifier = modifier.fillMaxWidth()
    )
}


/** Top bar for BreedsDetailsScreen **/
@Composable
fun BreedsDetailsTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = title) },
        backgroundColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
        elevation = 0.dp,
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
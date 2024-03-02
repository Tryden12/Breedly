package com.tryden.breedly.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.tryden.breedly.ui.common.BreedlyIcons
import com.tryden.breedly.utils.Constants
import com.tryden.breedly.utils.Constants.BREEDS
import com.tryden.breedly.utils.Constants.BREEDS_LIST_ROUTE
import com.tryden.breedly.utils.Constants.FAVORITES_ROUTE

/**
 * Type for the top level destinations in the application. Each of these destinations
 * can contain one or more screens (based on the window size). Navigation from one screen to the
 * next within a single destination will be handled directly in composables.
 */

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: String,
    val titleTextId: String,
    val route: String
) {
    BREEDS_LIST(
        selectedIcon = BreedlyIcons.List,
        unselectedIcon = BreedlyIcons.ListBorder,
        iconTextId = BREEDS,
        titleTextId = BREEDS,
        route = BREEDS_LIST_ROUTE
    ),
    FAVORITES(
        selectedIcon = BreedlyIcons.Favorite,
        unselectedIcon = BreedlyIcons.FavoriteBorder,
        iconTextId = Constants.FAVORITES,
        titleTextId = Constants.FAVORITES,
        route = FAVORITES_ROUTE
    )
}

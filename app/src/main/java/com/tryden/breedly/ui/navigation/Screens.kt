package com.tryden.breedly.ui.navigation

import androidx.annotation.StringRes
import com.tryden.breedly.R
import com.tryden.breedly.utils.Constants

/**
 * Type for the top level destinations in the application. Each of these destinations
 * can contain one or more screens (based on the window size). Navigation from one screen to the
 * next within a single destination will be handled directly in composables.
 */

enum class Screens(
    val route: String, @StringRes val resourceId: Int
) {
    BREEDS_LIST(
        route = Constants.BREEDS_LIST_ROUTE,
        resourceId = R.string.breeds_list
    ),
    BREED_DETAILS(
        route = Constants.BREED_DETAILS_ROUTE,
        resourceId = R.string.breed_details
    ),
    FAVORITES(
        route = Constants.FAVORITES_ROUTE,
        resourceId = R.string.favorites
    );

    fun createRoute(breedId: Int) = "details/$breedId"
}

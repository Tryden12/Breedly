package com.tryden.breedly.ui.navigation

import androidx.annotation.StringRes
import com.tryden.breedly.R
import com.tryden.breedly.utils.Constants.BREED_DETAILS_ROUTE
import com.tryden.breedly.utils.Constants.FAVORITES_ROUTE
import com.tryden.breedly.utils.Constants.HOME_ROUTE

/**
 * Sealed class for Breedly app screens.
 */
sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    data object Home : Screen(HOME_ROUTE, R.string.home)
    data object BreedDetails : Screen(BREED_DETAILS_ROUTE, R.string.breed_details) {
        fun createRoute(breedId: Int) = "details/$breedId"
    }
    data object Favorites : Screen(FAVORITES_ROUTE, R.string.favorites)

}
package com.tryden.breedly.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.res.stringResource
import com.tryden.breedly.R
import com.tryden.breedly.utils.Constants.DETAILS
import com.tryden.breedly.utils.Constants.FAVORITES
import com.tryden.breedly.utils.Constants.HOME

sealed class Screen(val route: String, routeValue: Int) {
    object Home: Screen(HOME, R.string.home)
    object Details: Screen(DETAILS, R.string.details)
    object Favorites: Screen(FAVORITES, R.string.favorites)

}

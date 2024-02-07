package com.tryden.breedly.ui.navigation

import androidx.annotation.StringRes
import com.tryden.breedly.R
import com.tryden.breedly.utils.Constants.DETAILS
import com.tryden.breedly.utils.Constants.FAVORITES
import com.tryden.breedly.utils.Constants.HOME

/**
 * enum values that represent the screens in the app.
 */
enum class BreedlyScreen(@StringRes val title: Int) {
    Home(title = R.string.home_route),
    Details(title = R.string.breed_details_route),
    Favorites(title = R.string.favorites_route)
}

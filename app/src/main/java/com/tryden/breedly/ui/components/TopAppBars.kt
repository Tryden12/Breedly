package com.tryden.breedly.ui.components

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
import com.tryden.breedly.R
import com.tryden.breedly.ui.navigation.Screen

/**
 * Composables that display the top bar.
 */
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
        backgroundColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground,
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
package com.tryden.breedly.ui.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.hilt.navigation.compose.hiltViewModel
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.viewmodels.FavoritesViewModel

/**
 * Composable for the favorite tag.
 */

@Composable
fun FavoriteHeart(
    breed: DogBreed,
    viewModel: FavoritesViewModel = hiltViewModel(),
    size: Float = 1f,
    modifier: Modifier = Modifier
) {
    var isFavorite by remember { mutableStateOf(breed.isFavorite) }

    Icon(
        tint = if (isFavorite) MaterialTheme.colorScheme.onTertiary
        else MaterialTheme.colorScheme.primary,
        imageVector =
        if (isFavorite) Icons.Filled.Favorite
        else Icons.Filled.FavoriteBorder,
        contentDescription = null,
        modifier = modifier
            .graphicsLayer {
                scaleX = size
                scaleY = size
            }
            .clickable {
                Log.d("ItemBreedCard()", "favorite clicked")
                isFavorite = !isFavorite
                viewModel.updateIsFavoriteBreed(breed, isFavorite)
            }
    )
}
package com.tryden.breedly.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.viewmodels.BreedListViewModel

/**
 * Composable for the favorite tag.
 */

@Composable
fun FavoriteTag(
    breed: DogBreed,
    viewModel: BreedListViewModel = hiltViewModel(),
) {
    var isFavorite by remember { mutableStateOf(breed.isFavorite) }

    Icon(
        tint = MaterialTheme.colorScheme.scrim,
        imageVector =
        if (isFavorite) Icons.Filled.Favorite
        else Icons.Filled.FavoriteBorder,
        contentDescription = null,
        modifier = Modifier
            .graphicsLayer {
                scaleX = 1f
                scaleY = 1f
            }
            .clickable {
                Log.d("ItemBreedCard()", "favorite clicked")
                isFavorite = !isFavorite
                viewModel.updateIsFavoriteBreed(breed, isFavorite)
            }
    )
}
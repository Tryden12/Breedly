package com.tryden.breedly.ui.feature.breed_favorites

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.ui.common.BreedlyIcons

/**
 * Composable for breed favorite card to be displayed in FavoritesScreen.
 */

@Composable
fun FavoriteBreedCard(
    breed: DogBreed,
    onDogBreedClicked: (Int) -> Unit,
    viewModel: FavoritesViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically ,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier.fillMaxWidth().clickable { onDogBreedClicked(breed.id) }
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = breed.imageLink),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = modifier
                .padding(12.dp)
                .size(45.dp)
                .clip(CircleShape)
        )
        Text(
            text = breed.name,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.titleSmall,
            modifier = modifier.padding(8.dp).weight(1f)
        )
        Icon(
            tint = MaterialTheme.colorScheme.primary,
            imageVector = BreedlyIcons.Info,
            contentDescription = null,
            modifier = modifier
                .padding(12.dp)
                .size(25.dp)
        )
    }
}
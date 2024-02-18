package com.tryden.breedly.ui.feature.breed_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tryden.breedly.R
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.ui.common.FavoriteTag

/**
 * Composable for dog breed item card.
 */

@Composable
fun ItemBreedCard(
    breed: DogBreed,
    viewModel: BreedListViewModel = hiltViewModel(),
    onItemClicked: (dog: DogBreed) -> Unit,
    modifier: Modifier
) {
    val height = 200.dp

    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .clickable { onItemClicked(breed) },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(breed.imageLink)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Crop,
                alignment = Alignment.CenterStart,
                contentDescription = breed.name,
                error = painterResource(id = R.drawable.ic_broken_image),
                placeholder = painterResource(id = R.drawable.loading_img),
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .size(height)
            )
            if (breed.isFavorite) {
                FavoriteTag(
                    modifier = modifier
                        .align(Alignment.TopStart)
                        .padding(12.dp, 8.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                MaterialTheme.colorScheme.primary
                            )
                        )
                    ),
            ) {
                Text(
                    text = breed.name,
                    maxLines = 3,
                    textAlign = TextAlign.Start,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(8.dp, 8.dp),
                )
            }
        }
    }
}

@Preview
@Composable
fun ItemBreedCardPreview() {
    ItemBreedCard(
        breed = DogBreed(),
        onItemClicked = { },
        modifier = Modifier
    )
}
package com.tryden.breedly.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.imageLoader
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.viewmodels.BreedDetailsViewModel

/**
 * Composable for displaying breed details.
 */
@Composable
fun BreedDetails(
    dogBreed: DogBreed,
    viewModel: BreedDetailsViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxWidth()) {
        AsyncImage(
            model = dogBreed.imageLink,
            contentDescription = "",
            imageLoader = LocalContext.current.imageLoader,
            modifier = modifier
                .fillMaxWidth()
                .height(400.dp),
            alignment = Alignment.CenterStart,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = modifier.padding(4.dp))

        Text(
            text = dogBreed.name,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = modifier.padding(4.dp))

         BreedAttributes(dogBreed = dogBreed, viewModel = viewModel)

    }
}
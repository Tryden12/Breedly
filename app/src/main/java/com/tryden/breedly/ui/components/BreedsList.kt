package com.tryden.breedly.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.viewmodels.BreedListViewModel

/**
 * Composable for displaying list of Breeds.
 */

@Composable
fun BreedsList(
    breedsList: List<DogBreed>,
    onDogBreedClicked: (Int) -> Unit,
    viewModel: BreedListViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    LazyColumn {
        breedsList.let { list ->
            items(list) { dogBreed ->
                ItemBreedCard(
                    breed = dogBreed,
                    viewModel,
                    onItemClicked = { dogBreed ->
                        onDogBreedClicked(dogBreed.id)
                    },
                )
            }
        }
    }
}
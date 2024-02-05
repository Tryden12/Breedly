package com.tryden.breedly.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.viewmodels.BreedListViewModel

/**
 * Composable for displaying list of Breeds.
 */

@Composable
fun BreedsList(
    breedsList: List<DogBreed>,
    viewModel: BreedListViewModel = hiltViewModel(),
) {
    LazyColumn {
        breedsList.let { list ->
            items(list) { dogBreed ->
                ItemBreedCard(
                    breed = dogBreed,
                    viewModel,
                    onItemClicked = { dogBreed ->
                        // todo navigate to dog breed details screen
                    },
                )
            }
        }
    }
}
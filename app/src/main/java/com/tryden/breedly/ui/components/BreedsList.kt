package com.tryden.breedly.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        content = {
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
    )
}
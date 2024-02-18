package com.tryden.breedly.ui.feature.breed_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tryden.breedly.domain.model.DogBreed

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
        modifier = modifier,
        content = {
            breedsList.let { list ->
                items(list) { dogBreed ->
                    ItemBreedCard(
                        breed = dogBreed,
                        viewModel,
                        onItemClicked = { dogBreed ->
                            onDogBreedClicked(dogBreed.id)
                        },
                        modifier = modifier
                    )
                }
            }
        }
    )
}
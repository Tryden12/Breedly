package com.tryden.breedly.ui.screens

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.viewmodels.BreedListViewModel

/**
 * Composable screen for displaying breed details.
 * We use the BreedDetailsViewState to handle UI state for this screen.
 */

sealed interface BreedDetailsViewState {
    object Loading: BreedDetailsViewState
    data class Error(val message: String) : BreedDetailsViewState
    data class Success(
        val dogBreed: DogBreed
    ) : BreedDetailsViewState
}

@Composable
fun BreedDetailsScreen(
    breedId: Int,
//    viewModel: BreedListViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    Log.d("BreedDetailsScreen", "breedId = $breedId")
    // Testing
    Text(text = "This is the BreedDetailsScreen()")
}
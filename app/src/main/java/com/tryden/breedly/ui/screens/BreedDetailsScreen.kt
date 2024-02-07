package com.tryden.breedly.ui.screens

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.ui.components.BreedsList
import com.tryden.breedly.viewmodels.BreedDetailsViewModel
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
    viewModel: BreedDetailsViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    Log.d("BreedDetailsScreen", "breedId = $breedId")
    // Testing
    Text(text = "This is the BreedDetailsScreen()")

    val viewState by viewModel.uiState.collectAsStateWithLifecycle()

    when (viewState) {
        is BreedDetailsViewState.Loading -> {
            Log.d("BreedDetailsScreen", "State LOADING")
        }
        is BreedDetailsViewState.Error -> {
            Log.d("BreedDetailsScreen", "State ERROR")

        }
        is BreedDetailsViewState.Success -> {
            Log.d("BreedDetailsScreen", "State SUCCESS: ")
            val dogBreed = (viewState as BreedDetailsViewState.Success).dogBreed

        }
    }
}
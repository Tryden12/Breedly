package com.tryden.breedly.ui.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.viewmodels.BreedListViewModel

/**
 * Composable screen for displaying breeds list.
 * We use the BreedsListViewState to handle UI state for this screen.
 */

sealed interface BreedsListViewState {
    object Loading: BreedsListViewState
    data class Error(val message: String) : BreedsListViewState
    data class Success(
        val breedsList: List<DogBreed>
    ) : BreedsListViewState
}

@Composable
fun BreedsListScreen(
    viewModel: BreedListViewModel = hiltViewModel(),
    toggleTheme: () -> Unit,
    modifier: Modifier = Modifier
) {
    val viewState by viewModel.uiState.collectAsState()

    when (viewState) {
        is BreedsListViewState.Loading -> {
            Log.d("BreedsListScreen", "State LOADING")
        }
        is BreedsListViewState.Error -> {
            Log.d("BreedsListScreen", "State ERROR")

        }
        is BreedsListViewState.Success -> {
            Log.d("BreedsListScreen", "State SUCCESS: ")
        }
    }

}
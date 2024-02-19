package com.tryden.breedly.ui.feature.breed_list

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.ui.common.ErrorScreen
import com.tryden.breedly.ui.common.BreedsListTopAppBar

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
    onDogBreedClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    val paddingValues = PaddingValues(horizontal = 12.dp, vertical = 4.dp)

    val viewState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(modifier.fillMaxWidth()) {
        // Top Bar
        BreedsListTopAppBar()

        when (viewState) {
            is BreedsListViewState.Loading -> {
                Log.d("BreedsListScreen", "State LOADING")
                LoadingBreedList()
            }

            is BreedsListViewState.Error -> {
                Log.d("BreedsListScreen", "State ERROR")
                ErrorScreen()
            }

            is BreedsListViewState.Success -> {
                Log.d("BreedsListScreen", "State SUCCESS: ")
                val breedsList = (viewState as BreedsListViewState.Success).breedsList
                BreedsList(
                    breedsList = breedsList,
                    onDogBreedClicked = onDogBreedClicked,
                    modifier = modifier
                )
            }
        }
    }
}
package com.tryden.breedly.ui.feature.breed_details

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.ui.common.BreedsDetailsTopAppBar

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
    currentScreenRoute: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    modifier: Modifier = Modifier
) {

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            BreedsDetailsTopAppBar(
                currentScreenRoute = currentScreenRoute,
                canNavigateBack = canNavigateBack,
                navigateUp = navigateUp
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Log.d("BreedDetailsScreen", "breedId = $breedId")
        // Testing

        val viewState by viewModel.uiState.collectAsStateWithLifecycle()

        when (viewState) {
            is BreedDetailsViewState.Loading -> {
                Log.d("BreedDetailsScreen", "State LOADING")
            }
            is BreedDetailsViewState.Error -> {
                Log.d("BreedDetailsScreen", "State ERROR")

            }
            is BreedDetailsViewState.Success -> {
                val dogBreed = (viewState as BreedDetailsViewState.Success).dogBreed
                Log.d("BreedDetailsScreen", "State SUCCESS: dog breed = ${dogBreed.name}")
                BreedDetails(
                    dogBreed = dogBreed,
                    viewModel = viewModel,
                    modifier = modifier.padding(paddingValues)
                )
            }
        }
    }
}
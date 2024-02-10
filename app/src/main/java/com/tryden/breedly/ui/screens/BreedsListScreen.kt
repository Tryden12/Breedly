package com.tryden.breedly.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.contentColorFor
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.ui.components.BreedsListTopAppBar
import com.tryden.breedly.ui.components.BreedsList
import com.tryden.breedly.ui.components.ThemeSwitcher
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
    onDogBreedClicked: (Int) -> Unit,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    modifier: Modifier = Modifier
) {
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { BreedsListTopAppBar() },
        modifier = modifier.fillMaxSize(),
        contentColor = contentColorFor(backgroundColor = MaterialTheme.colors.background)
    ) { paddingValues ->

        val viewState by viewModel.uiState.collectAsStateWithLifecycle()

        when (viewState) {
            is BreedsListViewState.Loading -> {
                Log.d("BreedsListScreen", "State LOADING")
            }

            is BreedsListViewState.Error -> {
                Log.d("BreedsListScreen", "State ERROR")

            }

            is BreedsListViewState.Success -> {
                Log.d("BreedsListScreen", "State SUCCESS: ")
                val breedsList = (viewState as BreedsListViewState.Success).breedsList
                BreedsList(
                    breedsList = breedsList,
                    onDogBreedClicked = onDogBreedClicked,
                    modifier = modifier.padding(paddingValues)
                )
            }
        }
    }

}
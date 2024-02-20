package com.tryden.breedly.ui.feature.breed_favorites

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.ui.common.BreedsListTopAppBar
import com.tryden.breedly.ui.common.ErrorScreen
import com.tryden.breedly.ui.feature.breed_list.LoadingBreedList

/**
 * Composable screen for displaying breeds list.
 * BreedsListViewState used to handle UI state for this screen.
 */

sealed interface FavoriteBreedsViewState {
    object Loading : FavoriteBreedsViewState
    
    data class Error(val message: String) : FavoriteBreedsViewState
    
    data class Success(
        val breedsList: List<DogBreed>
    ) : FavoriteBreedsViewState
}

@Composable
fun FavoritesScreen(
    viewModel: FavoritesViewModel = hiltViewModel(),
    onDogBreedClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val paddingValues = PaddingValues(horizontal = 12.dp, vertical = 4.dp)

    val viewState by viewModel.uiState.collectAsStateWithLifecycle()
    
    Column(modifier = modifier.fillMaxWidth()) {
        // Top bar TODO: update to have favorites title in top bar
        BreedsListTopAppBar()
        
        when(viewState) {
            is FavoriteBreedsViewState.Loading -> {
                Log.d("FavoritesScreen", "State LOADING")
                // todo loading state
                LoadingBreedList()
            }
            is FavoriteBreedsViewState.Error -> {
                Log.d("FavoritesScreen", "State ERROR")
                ErrorScreen()
            }
            is FavoriteBreedsViewState.Success -> {
                Log.d("FavoritesScreen", "State SUCCESS")
                val breedsList = (viewState as FavoriteBreedsViewState.Success).breedsList
                
                LazyColumn(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(breedsList.size) {
                        breedsList.forEach { dogBreed ->
                            FavoriteBreedCard(
                                breed = dogBreed,
                                onDogBreedClicked = {
                                    onDogBreedClicked(dogBreed.id)
                                }
                            )
                        }
                    }
                }
            }
                
        }
    }
}

@Preview
@Composable
fun FavoritesScreenPreview() {

}
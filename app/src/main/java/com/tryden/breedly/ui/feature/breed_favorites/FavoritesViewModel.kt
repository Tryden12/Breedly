package com.tryden.breedly.ui.feature.breed_favorites

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.domain.usecase.favorite_breeds.FavoriteBreedsUseCase
import com.tryden.breedly.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val favoriteBreedsUseCase: FavoriteBreedsUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow<FavoriteBreedsViewState>(FavoriteBreedsViewState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        getFavorites()
    }

    fun getFavorites() {
        // Loading state
        Log.d("FavoritesViewModel", "getFavorites [LOADING]")
        _uiState.update { FavoriteBreedsViewState.Loading }

        // Fetch favorites
        viewModelScope.launch {
            favoriteBreedsUseCase.getFavoriteBreeds().collect { list ->
                _uiState.update { return@update FavoriteBreedsViewState.Success(breedsList = list) }
                Log.d("FavoritesViewModel", "getFavorites SUCCESS: list size = ${list.size}")
            }
        }
    }

    // Updates the breed favorite status in local db
    fun updateIsFavoriteBreed(breed: DogBreed, isFavorite: Boolean) = viewModelScope.launch {
        try {
            favoriteBreedsUseCase.updateBreed(breed.id, isFavorite)
            Log.d("BreedListViewModel", "${breed.name} updated, favorite = $isFavorite")
        } catch (e: Exception) {
            Log.e("BreedListViewModel", "EXCEPTION: Attempted to update breed favorite status." +
                    " Exception: ${e.message}")
        }

    }
}
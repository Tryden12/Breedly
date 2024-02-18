package com.tryden.breedly.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.domain.usecase.favorite_breeds.FavoriteBreedsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val favoriteBreedsUseCase: FavoriteBreedsUseCase
): ViewModel() {


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
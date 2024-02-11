package com.tryden.breedly.viewmodels

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.domain.usecase.get_breed.GetBreedUseCase
import com.tryden.breedly.ui.screens.BreedDetailsViewState
import com.tryden.breedly.utils.Constants.BARKING
import com.tryden.breedly.utils.Constants.BREED_ID_KEY
import com.tryden.breedly.utils.Constants.ENERGY
import com.tryden.breedly.utils.Constants.PLAYFULNESS
import com.tryden.breedly.utils.Constants.PROTECTIVENESS
import com.tryden.breedly.utils.Constants.SHEDDING
import com.tryden.breedly.utils.Constants.TRAINABILITY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreedDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getBreedUseCase: GetBreedUseCase
) : ViewModel() {

    // Breed ID to use for fetching dog breed model from local db
    private val breedId: Int = checkNotNull(savedStateHandle[BREED_ID_KEY])

    private val _uiState = MutableStateFlow<BreedDetailsViewState>(BreedDetailsViewState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        getDogBreed(breedId)
    }

    fun getDogBreed(id: Int) {
        Log.d("BreedDetailsViewModel", "getDogBreed [LOADING] -- breedId from savedStateHandle = $breedId")
        _uiState.update { BreedDetailsViewState.Loading }

        viewModelScope.launch {
            try {
                getBreedUseCase.getDogBreed(id).let { dogBreed ->
                    Log.d("BreedDetailsViewModel", "getDogBreed SUCCESS: breedId = ${dogBreed.id}")
                    _uiState.update {
                        return@update BreedDetailsViewState.Success(dogBreed = dogBreed)
                    }
                }
            } catch (e: Exception) {
                Log.e("BreedDetailsViewModel", "getAllBreeds EXCEPTION: $e")
                _uiState.update {
                    return@update BreedDetailsViewState.Error(e.message.toString())
                }
            }
        }
    }

    fun createAttributesMap(dogBreed: DogBreed) : Map<String, Int> {
        return buildMap {
            put(TRAINABILITY, dogBreed.trainability)
            put(ENERGY, dogBreed.energy)
            put(PLAYFULNESS, dogBreed.playfulness)
            put(BARKING, dogBreed.barking)
            put(PROTECTIVENESS, dogBreed.protectiveness)
            put(SHEDDING, dogBreed.shedding)
        }
    }
}
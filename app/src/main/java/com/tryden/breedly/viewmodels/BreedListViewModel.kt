package com.tryden.breedly.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.domain.usecase.breeds_list.BreedsListUseCase
import com.tryden.breedly.domain.usecase.favorite_breeds.FavoriteBreedsUseCase
import com.tryden.breedly.ui.screens.BreedsListViewState
import com.tryden.breedly.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreedListViewModel @Inject constructor(
    private val breedsListUseCase: BreedsListUseCase,
    private val favoriteBreedsUseCase: FavoriteBreedsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<BreedsListViewState>(BreedsListViewState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        // Default to 1
        // API requires at least 1 parameter in fetch, so defaulting to use
        // minLifeExpectancy b/c every breed should have a min life expectancy of 1 year.
        getAllBreeds(minLifeExpectancy = 1)
    }

    fun getAllBreeds(minLifeExpectancy: Int) {
        viewModelScope.launch {
            breedsListUseCase.getAllBreeds(minLifeExpectancy).collect { resourceCase ->
                when (resourceCase) {
                    is Resource.Loading -> {
                        Log.d("BreedListViewModel", "getAllBreeds LOADING")
                        _uiState.update { BreedsListViewState.Loading }
                        return@collect
                    }
                    is Resource.Success -> {
                        resourceCase.data?.let { list ->
                            _uiState.update {
                                return@update BreedsListViewState.Success(breedsList = list)
                            }
                            Log.d("BreedListViewModel", "getAllBreeds SUCCESS: list size = ${list.size}")
                        } ?: return@collect

                    }
                    is Resource.Error -> {
                        // error state
                        resourceCase.error?.let { throwable ->
                            Log.e("BreedListViewModel", "getAllBreeds EXCEPTION: $throwable")
                            _uiState.update {
                                return@update BreedsListViewState.Error(throwable.message.toString())
                            }
                        }
                    }
                }
            }
        }
    }
}
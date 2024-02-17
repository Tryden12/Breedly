package com.tryden.breedly.domain.usecase.favorite_breeds

import com.tryden.breedly.domain.model.DogBreed
import kotlinx.coroutines.flow.Flow

/**
 * Use case interface for getting favorite breeds and updating breed favorite status.
 * This use case is injected to the view model wherever it is required.
 */
interface UseCase {
    fun getFavoriteBreeds(): Flow<List<DogBreed>>
    suspend fun updateBreed(id: Int, isFavorite: Boolean)
}
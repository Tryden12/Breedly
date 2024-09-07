package com.tryden.breedly.domain.usecase.favorite_breeds

import com.tryden.breedly.data.repository.DataRepository
import com.tryden.breedly.domain.model.DogBreed
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case class for getting favorite breeds and updating breed favorite status.
 * This use case is injected to the view model wherever it is required.
 */
class FavoriteBreedsUseCase @Inject constructor(
    private val dataRepository: DataRepository
) : UseCase {
    override fun getFavoriteBreeds(): Flow<List<DogBreed>> {
        return dataRepository.getFavoriteBreeds()
    }

    override suspend fun updateBreed(id: Int, isFavorite: Boolean) {
        dataRepository.updateBreed(id = id, isFavorite = isFavorite)
    }
}
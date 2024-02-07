package com.tryden.breedly.domain.usecase.get_breed

import com.tryden.breedly.data.repository.DataRepository
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case class for getting breed details of one dog breed.
 * This use case is injected to the view model wherever it is required.
 */
class GetBreedUseCase @Inject constructor(
    private val dataRepository: DataRepository
) : UseCase {
    override suspend fun getDogBreed(id: Int): DogBreed {
        return dataRepository.getDogBreed(id)
    }
}
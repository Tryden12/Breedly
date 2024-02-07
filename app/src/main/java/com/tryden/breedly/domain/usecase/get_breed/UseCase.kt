package com.tryden.breedly.domain.usecase.get_breed

import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.utils.Resource
import kotlinx.coroutines.flow.Flow


/**
 * Use case class for getting breed details of one dog breed.
 * This use case is injected to the view model wherever it is required.
 */
interface UseCase {
    suspend fun getDogBreed(id: Int): DogBreed
}
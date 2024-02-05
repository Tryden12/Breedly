package com.tryden.breedly.domain.usecase.breeds_list

import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.utils.Resource
import kotlinx.coroutines.flow.Flow


/**
 * Author: Muhammad Fawad Jawaid Malik
 * Use case class for getting all dog breeds list.
 * This use case is injected to the view model wherever it is required.
 */
interface UseCase {
    fun getAllBreeds(minLifeExpectancy: Int): Flow<Resource<List<DogBreed>>>

}
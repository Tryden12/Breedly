package com.tryden.breedly.domain.usecase.breeds_list

import com.tryden.breedly.data.repository.DataRepository
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case class for getting all dog breeds list.
 * This use case is injected to the view model wherever it is required.
 */
class BreedsListUseCase @Inject constructor(
    private val dataRepository: DataRepository
) : UseCase {
    override fun getAllBreeds(minLifeExpectancy: Int): Flow<Resource<List<DogBreed>>> {
        return dataRepository.getAllBreeds(minLifeExpectancy)
    }


}
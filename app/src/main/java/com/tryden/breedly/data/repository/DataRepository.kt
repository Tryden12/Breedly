package com.tryden.breedly.data.repository

import com.tryden.breedly.data.remote.dto.DogBreedResponse
import kotlinx.coroutines.flow.Flow


/**
 * In order to have a clean architecture, I have created this interface
 * and implementing it in DataRepositoryImpl class.
 */
interface DataRepository {

    fun getBreeds(minLifeExpectancy: Int) : Flow<List<DogBreedResponse>>
    fun searchBreeds(name: Int) : Flow<List<DogBreedResponse>>

}
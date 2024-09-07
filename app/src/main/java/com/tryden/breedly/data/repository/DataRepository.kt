package com.tryden.breedly.data.repository

import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.utils.Resource
import kotlinx.coroutines.flow.Flow


/**
 * In order to have a clean architecture, I have created this interface
 * and implementing it in DataRepositoryImpl class.
 */
interface DataRepository {

    fun getAllBreeds(minLifeExpectancy: Int): Flow<Resource<List<DogBreed>>>
    suspend fun getDogBreed(id: Int): DogBreed

    fun getFavoriteBreeds(): Flow<List<DogBreed>>
    suspend fun updateBreed(id: Int, isFavorite: Boolean)



//    Todo:
//    fun searchBreeds(name: String): Flow<List<DogBreed>>
//
//    suspend fun insertBreed(dogBreed: DogBreed)
//    suspend fun deleteBreed(dogBreed: DogBreed)
//    suspend fun deleteAll()

}
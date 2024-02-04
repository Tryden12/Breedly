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

//    Todo:
//    fun searchBreeds(name: String): Flow<List<DogBreed>>
//    fun getFavoriteBreeds(): Flow<List<DogBreed>>
//
//    suspend fun getBreed(name: String): DogBreed
//    suspend fun insertBreed(dogBreed: DogBreed)
//    suspend fun updateBreed(id: Int, isFavorite: Boolean)
//    suspend fun deleteBreed(dogBreed: DogBreed)
//    suspend fun deleteAll()

}
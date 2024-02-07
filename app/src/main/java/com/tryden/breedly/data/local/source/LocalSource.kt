package com.tryden.breedly.data.local.source

import com.tryden.breedly.domain.model.DogBreed
import kotlinx.coroutines.flow.Flow

interface LocalSource {

    fun getAllBreeds(): Flow<List<DogBreed>>
    fun searchBreeds(name: String): Flow<List<DogBreed>>
    fun getFavoriteBreeds(): Flow<List<DogBreed>>


    suspend fun getDogBreed(id: Int): DogBreed
    suspend fun insertAllBreeds(dogBreeds: List<DogBreed>)

    suspend fun insertBreed(dogBreed: DogBreed)
    suspend fun updateBreed(id: Int, isFavorite: Boolean)
    suspend fun deleteBreed(dogBreed: DogBreed)
    suspend fun deleteAll()

}
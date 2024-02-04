package com.tryden.breedly.data.remote

import com.tryden.breedly.data.remote.dto.DogBreedResponse
import com.tryden.breedly.utils.Resource

interface RemoteSource {

    suspend fun getBreeds(minLifeExpectancy: Int): Resource<List<DogBreedResponse>>

    suspend fun searchBreeds(name: Int): Resource<List<DogBreedResponse>>

}
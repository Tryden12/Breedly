package com.tryden.breedly.data.remote.source

import com.tryden.breedly.data.remote.response.DogBreedResponse
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.utils.Resource

interface RemoteSource {

    suspend fun getBreeds(minLifeExpectancy: Int): Resource<List<DogBreed>>

    suspend fun searchBreeds(name: Int): Resource<List<DogBreedResponse>>

}
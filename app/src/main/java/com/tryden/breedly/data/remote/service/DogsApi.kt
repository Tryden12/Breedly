package com.tryden.breedly.data.remote.service

import com.tryden.breedly.data.remote.dto.DogBreedResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * A public interface that exposes the get method(s).
 */
interface DogsApi {

    /**
     * Returns a [List] of [DogBreedResponse] and this method can be called from a Coroutine.
     */
    @GET("dogs")
    suspend fun getBreeds(
        @Query("min_life_expectancy") minLifeExpectancy: Int = 1,
//        @Query("offset") offset: Int
    ): Response<List<DogBreedResponse>>

    /**
     * Returns a [DogBreedResponse] and this method can be called from a Coroutine.
     * The @GET annotation takes a @Query parameter [name] to get data for name of dog breed.
     */
    @GET("dogs")
    suspend fun searchBreeds(
        @Query("name") name: String = "",
    ) : Response<List<DogBreedResponse>>
}
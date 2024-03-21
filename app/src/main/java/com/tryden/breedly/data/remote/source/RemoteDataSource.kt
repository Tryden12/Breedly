package com.tryden.breedly.data.remote.source

import android.util.Log
import com.tryden.breedly.data.remote.response.DogBreedResponse
import com.tryden.breedly.data.remote.service.DogsApi
import com.tryden.breedly.domain.DogBreedMapper
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.utils.Resource
import javax.inject.Inject


/**
 * We fetch data from remote source: dog api.
 * We utilize the Resource class for Success, Loading, and DataError cases.
 */
class RemoteDataSource @Inject
constructor(
    val dogsApi: DogsApi,
    private val mapper: DogBreedMapper
) : RemoteSource {
    override suspend fun getBreeds(minLifeExpectancy: Int): Resource<List<DogBreed>> {
        return try {
            val response = dogsApi.getBreeds(minLifeExpectancy)
            val body = response.body()
            if (response.isSuccessful && body !=null) {
                val list = body.map {
                    mapper.buildFrom(it)
                }
                Resource.Success(data = list)
            } else {
                Resource.Error(throwable = Throwable(response.message()))
            }
        } catch (exception: Exception) {
            return Resource.Error(throwable = exception)
        }
    }

    override suspend fun searchBreeds(name: Int): Resource<List<DogBreedResponse>> {
        try {
            val res = dogsApi.getBreeds(name)

            when(res.isSuccessful) {
                true -> {
                    res.body()?.let { breedList ->
                        Log.d("RemoteDataSource", "Search Breed list: ${breedList.size}" )
                        return Resource.Success(data = breedList)
                    } ?: return Resource.Error()
                }
                false -> {
                    Log.d("RemoteDataSource", "Search Breed list: 0 -> NOT SUCCESSFUL, res code: ${res.code()}" )
                    return Resource.Error()
                }
            }

        } catch (exception: Exception) {
            Log.e("RemoteDataSource", "Search Breed list Exception: $exception")
            return Resource.Error(throwable = exception)
        }
    }
}
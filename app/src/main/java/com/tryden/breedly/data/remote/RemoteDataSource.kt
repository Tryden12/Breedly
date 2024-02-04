package com.tryden.breedly.data.remote

import android.util.Log
import com.tryden.breedly.data.Resource
import com.tryden.breedly.data.remote.dto.DogBreedResponse
import com.tryden.breedly.data.remote.service.DogsApi
import javax.inject.Inject


/**
 * We fetch data from remote source: dog api.
 * We utilize the Resource class for Success, Loading, and DataError cases.
 */
class RemoteDataSource @Inject
constructor(val dogsApi: DogsApi) : RemoteSource {
    override suspend fun getBreeds(minLifeExpectancy: Int): Resource<List<DogBreedResponse>> {
        try {
            val res = dogsApi.getBreeds(minLifeExpectancy)

            when(res.isSuccessful) {
                true -> {
                    res.body()?.let { breedList ->
                        Log.d("RemoteDataSource", "Breed list: ${breedList.size}" )
                        return Resource.Success(data = breedList)
                    } ?: return Resource.DataError(errorCode = res.code())
                }
                false -> {
                    Log.d("RemoteDataSource", "Breed list: 0 -> NOT SUCCESSFUL, res code: ${res.code()}" )
                    return Resource.DataError(errorCode = res.code())
                }
            }

        } catch (e: Exception) {
            Log.e("RemoteDataSource", "Breed list: Exception hash code: ${e.hashCode()}")
            return Resource.DataError(errorCode = e.hashCode())
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
                    } ?: return Resource.DataError(errorCode = res.code())
                }
                false -> {
                    Log.d("RemoteDataSource", "Search Breed list: 0 -> NOT SUCCESSFUL, res code: ${res.code()}" )
                    return Resource.DataError(errorCode = res.code())
                }
            }

        } catch (e: Exception) {
            Log.e("RemoteDataSource", "Search Breed list: Exception hash code: ${e.hashCode()}")
            return Resource.DataError(errorCode = e.hashCode())
        }
    }
}
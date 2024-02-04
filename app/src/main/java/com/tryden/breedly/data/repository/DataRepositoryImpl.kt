package com.tryden.breedly.data.repository

import android.util.Log
import com.tryden.breedly.data.remote.RemoteSource
import com.tryden.breedly.data.remote.dto.DogBreedResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * This is the Repository class which fetches the data from the remote source and emits the list to
 * the domain layer.
 * In the domain layer, the dto models will be mapped to UI models.
 */
class DataRepositoryImpl @Inject constructor(
    private val remoteSource: RemoteSource
) : DataRepository {

    /**
     * We use flow on Dispatchers.IO thread to fetch the breed list data.
     */
    override fun getBreeds(minLifeExpectancy: Int): Flow<List<DogBreedResponse>> {
        return flow {
            remoteSource.getBreeds(minLifeExpectancy).data?.let { list ->
                Log.d("DataRepositoryImpl", "Breed list size: ${list.size}" )
                emit(list)
            }
        }.flowOn(Dispatchers.IO)
    }

    /**
     * We use flow on Dispatchers.IO thread to fetch the search of dog breed list data.
     */
    override fun searchBreeds(name: Int): Flow<List<DogBreedResponse>> {
        return flow {
            remoteSource.searchBreeds(name).data?.let { list ->
                Log.d("DataRepositoryImpl", "Search Breed list size: ${list.size}" )
                emit(list)
            }
        }.flowOn(Dispatchers.IO)
    }


}
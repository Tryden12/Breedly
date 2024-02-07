package com.tryden.breedly.data.repository

import android.util.Log
import com.tryden.breedly.data.local.source.LocalSource
import com.tryden.breedly.data.remote.RemoteSource
import com.tryden.breedly.data.remote.dto.DogBreedResponse
import com.tryden.breedly.domain.DogBreedMapper
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.utils.Resource
import com.tryden.breedly.utils.networkBoundResource
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
    private val remoteSource: RemoteSource,
    private val localSource: LocalSource,
    private val dogBreedMapper: DogBreedMapper
) : DataRepository {

    /**
     * We use the networkBoundResource() inline to function to flow on Dispatchers.IO
     * to do the following in order:
     * (1) [query] fetch from local db
     * (2a) [fetch] fetch from remote (if needed)
     * (2b) [saveFetchResult] map response (if fetched) from remote and save to local
     * (3) emit flow
     */
    override fun getAllBreeds(minLifeExpectancy: Int): Flow<Resource<List<DogBreed>>> {
        return networkBoundResource(
            query = {
                localSource.getAllBreeds()
            },
            fetch = {
                remoteSource.getBreeds(minLifeExpectancy)
            },
            saveFetchResult = {
                localSource.deleteAll()
                it.data?.let { listDto ->
                    val list = listDto.map { dogBreedDto ->
                        dogBreedMapper.buildFrom(dogBreedDto)
                    }
                    localSource.insertAllBreeds(list)
                }
            }
        )
    }

    override suspend fun getDogBreed(id: Int): DogBreed {
        return localSource.getDogBreed(id)
    }

    /**
     * We use flow on Dispatchers.IO thread to fetch the search of dog breed list data.
     */
//    override fun searchBreeds(name: String): Flow<List<DogBreed>> {
//        // todo
//    }
//
//    override fun getFavoriteBreeds(): Flow<List<DogBreed>> {
//        // todo
//    }
//
//
//    override suspend fun insertBreed(dogBreed: DogBreed) {
//        // todo
//    }
//
//    override suspend fun updateBreed(id: Int, isFavorite: Boolean) {
//        // todo
//    }
//
//    override suspend fun deleteBreed(dogBreed: DogBreed) {
//        // todo
//    }
//
//    override suspend fun deleteAll() {
//        // todo
//    }


}
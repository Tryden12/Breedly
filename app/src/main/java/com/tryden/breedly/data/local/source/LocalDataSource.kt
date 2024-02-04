package com.tryden.breedly.data.local.source

import com.tryden.breedly.data.local.dao.DogBreedsDao
import com.tryden.breedly.domain.model.DogBreed
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * This is the local data source, we are fetching and storing all the needed entities and values
 * into room database.
 */
class LocalDataSource @Inject constructor(
    private val breedsDao: DogBreedsDao
) : LocalSource {


    override fun getAllBreeds(): Flow<List<DogBreed>> {
        return breedsDao.getAllBreeds()
    }

    override fun searchBreeds(name: String): Flow<List<DogBreed>> {
        return breedsDao.searchBreeds(name)
    }

    override fun getFavoriteBreeds(): Flow<List<DogBreed>> {
        return breedsDao.getFavoriteBreeds()
    }

    override suspend fun getBreed(name: String): DogBreed {
        return breedsDao.getBreed(name)
    }

    override suspend fun insertAllBreeds(dogBreeds: List<DogBreed>) {
        breedsDao.insertAllBreeds(dogBreeds)
    }


    override suspend fun insertBreed(dogBreed: DogBreed) {
        breedsDao.insertBreed(dogBreed)
    }

    override suspend fun updateBreed(id: Int, isFavorite: Boolean) {
        breedsDao.updateBreed(id, isFavorite)
    }

    override suspend fun deleteBreed(dogBreed: DogBreed) {
        breedsDao.deleteBreed(dogBreed)
    }

    override suspend fun deleteAll() {
        breedsDao.deleteAll()
    }
}
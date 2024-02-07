package com.tryden.breedly.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tryden.breedly.domain.model.DogBreed
import kotlinx.coroutines.flow.Flow


/**
 * This is the DAO (Data Access Object) class for dog breeds database.
 * It contains all the queries for the database:
 * (1) get, insert, and delete all breeds
 * (2) search, insert, update, delete specific breed
 */

@Dao
interface DogBreedsDao {

    @Query("SELECT * FROM dogbreed")
    fun getAllBreeds(): Flow<List<DogBreed>>

    /**
     * Use to search for breeds containing the characters.
     */
    @Query("SELECT * FROM dogbreed WHERE name LIKE :name")
    fun searchBreeds(name: String): Flow<List<DogBreed>>

    /**
     * Get all favorite breeds.
     */
    @Query("SELECT * FROM dogbreed WHERE is_favorite = 1")
    fun getFavoriteBreeds(): Flow<List<DogBreed>>

    /**
     * Get specific breed.
     */
    @Query("SELECT * FROM dogbreed WHERE id = :id")
    suspend fun getBreed(id: Int): DogBreed

    /**
     * Insert all breeds.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBreeds(dogBreeds: List<DogBreed>)

    /**
     * Insert specific breed.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBreed(dogBreed: DogBreed)

    /**
     * Update breed.
     */
    @Query("UPDATE dogbreed SET is_favorite = :isFavorite WHERE name LIKE :id")
    suspend fun updateBreed(id: Int, isFavorite: Boolean)


    /**
     * Delete a breed from the table.
     */
    @Delete
    suspend fun deleteBreed(dogBreed: DogBreed)

    /**
     * This removes the table.
     */
    @Query("DELETE FROM dogbreed")
    suspend fun deleteAll()


}


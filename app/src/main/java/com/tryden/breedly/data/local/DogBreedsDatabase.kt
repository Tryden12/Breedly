package com.tryden.breedly.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tryden.breedly.data.local.dao.DogBreedsDao
import com.tryden.breedly.domain.model.DogBreed

/**
 * This class is to create Dog Breeds database.
 */
@Database(version = 1, entities = [DogBreed::class], exportSchema = false)
abstract class DogBreedsDatabase : RoomDatabase() {
    abstract fun dogBreedsDao(): DogBreedsDao
}
package com.tryden.breedly.di

import android.content.Context
import androidx.room.Room
import com.tryden.breedly.data.local.DogBreedsDatabase
import com.tryden.breedly.data.local.dao.DogBreedsDao
import com.tryden.breedly.data.local.source.LocalDataSource
import com.tryden.breedly.data.local.source.LocalSource
import com.tryden.breedly.data.remote.RemoteDataSource
import com.tryden.breedly.data.remote.RemoteSource
import com.tryden.breedly.data.remote.dto.DogBreedResponse
import com.tryden.breedly.data.remote.service.DogsApi
import com.tryden.breedly.domain.DogBreedMapper
import com.tryden.breedly.domain.Mapper
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.utils.Constants.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * This is the DbModule class which provides our database and dao dependency wherever it is required.
 */

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext app: Context) = Room
        .databaseBuilder(
            app,
            DogBreedsDatabase::class.java,
            DB_NAME
    ).fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()


    @Provides
    @Singleton
    fun provideDogBreedDao(db: DogBreedsDatabase): DogBreedsDao = db.dogBreedsDao()

    @Provides
    @Singleton
    fun provideLocalSource(breedsDao: DogBreedsDao) : LocalSource {
        return LocalDataSource(breedsDao)
    }

//    @Provides
//    @Singleton
//    fun bindDogBreedMapper(dogBreedMapper: DogBreedMapper) : Mapper<DogBreed, DogBreedResponse> {
//        return dogBreedMapper
//    }

}
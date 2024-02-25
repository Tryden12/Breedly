package com.tryden.breedly.di

import com.tryden.breedly.data.remote.dto.DogBreedResponse
import com.tryden.breedly.data.repository.DataRepository
import com.tryden.breedly.data.repository.DataRepositoryImpl
import com.tryden.breedly.domain.DogBreedMapper
import com.tryden.breedly.domain.Mapper
import com.tryden.breedly.domain.model.DogBreed
import com.tryden.breedly.utils.ConnectivityManagerNetworkMonitor
import com.tryden.breedly.utils.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Binds
    @Singleton
    fun bindDataRepository(dataRepositoryImpl: DataRepositoryImpl): DataRepository

    @Binds
    @Singleton
    fun bindDogBreedMapper(dogBreedMapper: DogBreedMapper) : Mapper<DogBreed, DogBreedResponse>

    @Binds
    @Singleton
    fun bindsNetworkMonitor(
        networkMonitor: ConnectivityManagerNetworkMonitor,
    ): NetworkMonitor
}
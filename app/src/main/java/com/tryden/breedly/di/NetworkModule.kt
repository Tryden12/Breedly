package com.tryden.breedly.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tryden.breedly.data.remote.source.RemoteDataSource
import com.tryden.breedly.data.remote.source.RemoteSource
import com.tryden.breedly.data.remote.service.DogsApi
import com.tryden.breedly.domain.DogBreedMapper
import com.tryden.breedly.utils.Constants.BASE_URL
import com.tryden.breedly.utils.MyInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * This is the Hilt NetworkModule class which provides the following dependencies:
 * retrofit, client, service
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /**
     * Retrofit singleton.
     * Params: [client] [moshi] provided as singletons below.
     */
    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()


    @Provides
    @Singleton
    fun createClient(): OkHttpClient {
        val client = OkHttpClient.Builder().apply {
            addInterceptor(MyInterceptor())
        }.build()
        return client
    }

    @Provides
    @Singleton
    fun provideDogService(retrofit: Retrofit): DogsApi {
        return retrofit.create(DogsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteSource(api: DogsApi, mapper: DogBreedMapper) : RemoteSource {
        return RemoteDataSource(api, mapper)
    }

}
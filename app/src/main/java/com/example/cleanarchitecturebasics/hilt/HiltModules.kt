package com.example.cleanarchitecturebasics.hilt

import com.example.cleanarchitecturebasics.common.Constants
import com.example.cleanarchitecturebasics.data.remote.SampleBasicAPI
import com.example.cleanarchitecturebasics.data.repository.GetModelListImpl
import com.example.cleanarchitecturebasics.domain.repository.ModelListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent ::class)
@Module
object HiltModules {

@Provides
@Singleton
fun provideSampleBasicAPI() : SampleBasicAPI{
    return Retrofit.Builder().baseUrl(Constants.Base_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()
        .create(SampleBasicAPI::class.java)
}


    @Provides
    fun provideModelListRepository(sampleBasicAPI: SampleBasicAPI) : ModelListRepository{
        return GetModelListImpl(sampleBasicAPI)

    }
}
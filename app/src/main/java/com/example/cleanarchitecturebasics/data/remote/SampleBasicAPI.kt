package com.example.cleanarchitecturebasics.data.remote

import com.example.cleanarchitecturebasics.data.model.ModelDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface SampleBasicAPI {

    @GET("sample/api/v1/")
    suspend fun getDataList(@Query("s") s: String) : ModelDTO

    @GET("detail/api/v1")
    suspend fun getDetails(@Query("i") id : String) : ModelDTO

}
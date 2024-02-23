package com.example.cleanarchitecturebasics.data.repository

import com.example.cleanarchitecturebasics.data.model.ModelDTO
import com.example.cleanarchitecturebasics.data.remote.SampleBasicAPI
import com.example.cleanarchitecturebasics.domain.repository.ModelListRepository

class GetModelListImpl(private val sampleBasicAPI: SampleBasicAPI) : ModelListRepository {
    override suspend fun getDataList(s: String): ModelDTO {
        return sampleBasicAPI.getDataList(s)
    }
}
package com.example.cleanarchitecturebasics.domain.repository

import com.example.cleanarchitecturebasics.data.model.ModelDTO

interface ModelListRepository {
    suspend fun getDataList(s : String) : ModelDTO
}
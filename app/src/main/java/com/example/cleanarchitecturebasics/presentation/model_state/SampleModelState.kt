package com.example.cleanarchitecturebasics.presentation.model_state

import com.example.cleanarchitecturebasics.domain.model.SampleModel

data class SampleModelState (
    val isLoading: Boolean = false,
    val data: SampleModel? = null,
    val error: String = ""
)
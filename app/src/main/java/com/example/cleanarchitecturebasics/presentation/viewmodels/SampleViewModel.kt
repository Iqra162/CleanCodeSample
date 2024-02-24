package com.example.cleanarchitecturebasics.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturebasics.common.Resource
import com.example.cleanarchitecturebasics.domain.use_case.ModelListUseCase
import com.example.cleanarchitecturebasics.presentation.model_state.SampleModelState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

class SampleViewModel @Inject constructor(private  val useCase: ModelListUseCase) : ViewModel() {

    val _sampleModelValue = MutableStateFlow<SampleModelState>(SampleModelState())
    val sampleModelValue : StateFlow<SampleModelState> = _sampleModelValue


    fun getSearchMeals(s: String) {
        useCase(s).onEach {
            when (it) {
                is Resource.Loading -> {
                    _sampleModelValue.value = SampleModelState(isLoading = true)
                }

                is Resource.Error -> {
                    _sampleModelValue.value = SampleModelState(error = it.message ?: "")
                }

                is Resource.Success -> {
                    _sampleModelValue.value = SampleModelState(data = it.data)
                }
            }
        }.launchIn(viewModelScope)


    }


}
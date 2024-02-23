package com.example.cleanarchitecturebasics.data.model

import com.example.cleanarchitecturebasics.domain.model.SampleModel

data  class ModelDTO (
    var value1 : String? ="",
    var value2 : String? =""
)

fun ModelDTO.toDomainSampleModel() : SampleModel{
    return SampleModel(
        value1 =this.value1
    )
}
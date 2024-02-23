package com.example.cleanarchitecturebasics.domain.use_case

import com.example.cleanarchitecturebasics.common.Resource
import com.example.cleanarchitecturebasics.data.model.toDomainSampleModel
import com.example.cleanarchitecturebasics.domain.model.SampleModel
import com.example.cleanarchitecturebasics.domain.repository.ModelListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ModelListUseCase @Inject constructor(private val repository: ModelListRepository) {

    operator fun invoke(s: String): Flow<Resource<SampleModel>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.getDataList(s)
            val list: SampleModel = if (response == null) SampleModel() else {
                response.toDomainSampleModel()
            }
            emit(Resource.Success(data = list))


        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An Unknown error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Check Connectivity"))
        } catch (e: Exception) {

        }
    }
}
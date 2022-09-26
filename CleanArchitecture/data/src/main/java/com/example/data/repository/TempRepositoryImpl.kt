package com.example.data.repository

import com.example.data.mapper.TempMapper
import com.example.data.repository.Temp.TempRemoteDataSource
import com.example.domain.model.Temp
import com.example.domain.repository.TempRepository
import com.example.domain.util.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TempRepositoryImpl @Inject constructor(
    private val tempRemoteDataSource: TempRemoteDataSource
) : TempRepository {

    override suspend fun getTempList(page: Int): Result<List<Temp>> {
        return try {
            val response = withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                tempRemoteDataSource.getTempList(page)
            }

            if (response.isSuccessful && response.body() != null) {
                Result.success(TempMapper.mapperToTempList(response.body()!!))
            } else {
                Result.error(response.errorBody().toString(), null)
            }
        } catch (error: Exception) {
            Result.fail()
        }
    }
}
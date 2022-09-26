package com.example.data.repository.Temp

import com.example.data.model.TempEntity
import retrofit2.Response

interface TempRemoteDataSource {
    suspend fun getTempList(page: Int): Response<List<TempEntity>>
}
package com.example.data.repository.Temp

import com.example.data.api.TempApi
import com.example.data.model.TempEntity
import retrofit2.Response
import javax.inject.Inject

class TempRemoteDataSourceImpl @Inject constructor(
    private val tempApi: TempApi
) : TempRemoteDataSource {

    override suspend fun getTempList(page: Int): Response<List<TempEntity>> {
        return tempApi.getTempList(page)
    }
}
package com.example.domain.repository

import com.example.domain.model.Temp
import com.example.domain.util.Result

interface TempRepository {
    suspend fun getTempList(page: Int): Result<List<Temp>>
}
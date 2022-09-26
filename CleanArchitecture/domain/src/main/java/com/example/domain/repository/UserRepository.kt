package com.example.domain.repository

import com.example.domain.model.User
import com.example.domain.util.Result
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun readUserList(): Flow<List<User>>
    suspend fun writeUser(user: User): Result<Any>
}
package com.example.data.repository.User

import com.example.data.model.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserLocalDataSource {
    fun readUserList(): Flow<List<UserEntity>>
    suspend fun writeUser(userEntity: UserEntity)
}
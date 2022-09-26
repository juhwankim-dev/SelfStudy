package com.example.data.repository

import com.example.data.mapper.UserMapper
import com.example.data.repository.User.UserLocalDataSource
import com.example.domain.model.User
import com.example.domain.repository.UserRepository
import com.example.domain.util.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource
) : UserRepository {

    override fun readUserList(): Flow<List<User>> {
        return userLocalDataSource.readUserList().map { UserMapper.mapperToUserList(it) }
    }

    override suspend fun writeUser(user: User): Result<Any> {
        return try {
            withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                userLocalDataSource.writeUser(UserMapper.mapperToUserEntity(user))
            }
            Result.success(null)
        } catch (error: Exception) {
            Result.error(error.message.toString(), null)
        }
    }
}
package com.example.data.repository.User

import com.example.data.db.UserDao
import com.example.data.model.UserEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserLocalDataSourceImpl @Inject constructor(
    private val dao: UserDao
): UserLocalDataSource {
    override fun readUserList(): Flow<List<UserEntity>> {
        return dao.readUserList()
    }

    override suspend fun writeUser(userEntity: UserEntity) {
        return dao.writeUser(userEntity)
    }
}
package com.example.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.model.UserEntity
import com.example.domain.util.Constants.TABLE_NAME
import kotlinx.coroutines.flow.Flow

// Room과 관련된 포스팅: https://todaycode.tistory.com/39
@Dao
interface UserDao {
    @Query("SELECT * FROM $TABLE_NAME")
    fun readUserList(): Flow<List<UserEntity>>

    @Insert
    suspend fun writeUser(userEntity: UserEntity)
}
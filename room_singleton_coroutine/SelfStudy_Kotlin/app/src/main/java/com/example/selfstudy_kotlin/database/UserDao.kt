package com.example.selfstudy_kotlin.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    fun getAll(): List<User>

    @Insert
    fun insert(user: User)

    @Query("DELETE FROM User WHERE name = :name")
    fun deleteUserByName(name: String)
}
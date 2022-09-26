package com.example.data.mapper

import com.example.data.model.UserEntity
import com.example.domain.model.User

object UserMapper {
    fun mapperToUserEntity(user: User): UserEntity {
        return UserEntity(
            id = user.id
        )
    }

    fun mapperToUserList(userEntityList: List<UserEntity>): List<User> {
        return userEntityList.toList().map {
            User(
                id = it.id
            )
        }
    }
}
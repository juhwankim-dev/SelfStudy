package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.util.Constants

@Entity(tableName = Constants.TABLE_NAME) // DB에 저장하기 위해서는 @Entity 어노테이션이 필요합니다.
data class UserEntity(
    @PrimaryKey // DB에 저장하기 위해서는 @PrimaryKey로 변수를 하나 지정해주어야 합니다.
    val id: String
)
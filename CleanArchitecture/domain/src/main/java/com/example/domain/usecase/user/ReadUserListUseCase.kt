package com.example.domain.usecase.user

import com.example.domain.model.User
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

// 저는 서버에서 값을 받아오는 usecase와
// DB에서 값을 가져오는 usecase의 구분을 위해
// DB는 ReadXXX, WriteXXX 네이밍 규칙을 사용했어요.
class ReadUserListUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(): Flow<List<User>> = userRepository.readUserList()
}
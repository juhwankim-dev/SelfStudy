package com.example.domain.usecase.temp

import com.example.domain.model.Temp
import com.example.domain.repository.TempRepository
import com.example.domain.util.Result
import javax.inject.Inject

// 저는 GetXXXUseCase 네이밍을 사용했어요.
// Post면 PostXXXUseCase 이렇게요.
class GetTempListUseCase @Inject constructor( // 의존성 주입을 위해 @Inject 어노테이션이 필요합니다.
    private val tempRepository: TempRepository
) {
    suspend operator fun invoke(page: Int): Result<List<Temp>> = tempRepository.getTempList(page)
}
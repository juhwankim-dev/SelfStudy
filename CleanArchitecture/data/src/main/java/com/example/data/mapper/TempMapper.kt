package com.example.data.mapper

import com.example.data.model.TempEntity
import com.example.domain.model.Temp

// mapper를 통해서 entity -> dto로 변환합니다.
// 1. 서버에서 받을 때 사용하는 data class와
// 클라이언트에서 사용하는 data class를 구분하기 위함이고
// 2. 데이터를 가공하는 작업도 저는 여기서 진행합니다.
object TempMapper {
    fun mapperToTempList(tempEntityList: List<TempEntity>): List<Temp> {
        return tempEntityList.toList().map {
            Temp(
                name = it.name
            )
        }
    }
}
package com.example.domain.model

// domain과 presentation 레이어에서는 여기에 있는 data class를 사용합니다.
// Mapper를 통해 가공된 데이터이기 때문에 더 이상 값의 수정이 필요없고
// presentation 레이어에서 바로 사용하기만 하면 됩니다.
data class Temp(
    val name: String
)

package com.example.data.api

import com.example.data.model.TempEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TempApi {
    @GET("")
    suspend fun getTempList(
        @Query("page") page: Int,
        @Query("perPage") perPage: Int = 10
    ): Response<List<TempEntity>>
}

// 저는 get요청이면 getXXX, post요청이면 postXXX 이렇게 이름을 정하곤 했어요.
// 리스트 형식으로 값을 받으면 getXXXList, 아니라면 getXXX 이렇게 이름을 정하곤 했습니다.

// 저는 서버에서 받아오는 data는 XXXEntity로
// 맵핑을 통해 클라이언트에서 사용할 data는 XXX로 이름을 정하곤 했습니다.

// 여러분들은 어떤 네이밍을 사용하시나요? 좋은 방법 같이 찾아봐요 :D
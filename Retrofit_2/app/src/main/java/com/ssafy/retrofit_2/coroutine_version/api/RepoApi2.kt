package com.ssafy.retrofit_2.coroutine_version.api

import com.ssafy.retrofit_2.common.dto.RepoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RepoApi2 {
    @GET("search/repositories")
    suspend fun selectAllRepos(@Query("q") q: String, @Query("per_page") per_page: String, @Query("page") page: String): Response<RepoResponse>
}
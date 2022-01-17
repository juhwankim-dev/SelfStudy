package com.ssafy.retrofit_2.callback_version.api

import com.ssafy.retrofit_2.common.dto.RepoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RepoApi1 {
    @GET("search/repositories")
    fun selectAllRepos(@Query("q") q: String, @Query("per_page") per_page: String, @Query("page") page: String): Call<RepoResponse>
}
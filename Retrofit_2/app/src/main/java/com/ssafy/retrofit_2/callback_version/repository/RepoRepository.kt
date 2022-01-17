package com.ssafy.retrofit_2.callback_version.repository

import com.ssafy.retrofit_2.common.dto.RepoResponse
import com.ssafy.retrofit_2.common.config.ApplicationClass.Companion.PER_PAGE
import com.ssafy.retrofit_2.callback_version.util.RetrofitCallback
import com.ssafy.retrofit_2.callback_version.util.RetrofitUtil1
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RepoRepository {
    fun selectAllRepos(q: String, page: Int, callback: RetrofitCallback<RepoResponse>) {
        RetrofitUtil1.repoService1.selectAllRepos(q, PER_PAGE.toString(), page.toString()).enqueue(object: Callback<RepoResponse> {
            override fun onResponse(
                call: Call<RepoResponse>,
                response: Response<RepoResponse>
            ) {
                if (response.code() == 200) {
                    callback.onSuccess(response.code(), response.body()!!)
                } else {
                    callback.onError(response.code())
                }
            }

            override fun onFailure(call: Call<RepoResponse>, t: Throwable) {
                callback.onFailure(t)
            }
        })
    }
}
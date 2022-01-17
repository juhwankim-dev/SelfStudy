package com.ssafy.retrofit_2.coroutine_mvvm_version.src

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ssafy.retrofit_2.common.dto.RepoResponse
import com.ssafy.retrofit_2.coroutine_mvvm_version.repository.RepoRepository3

class RetrofitViewModel : ViewModel() {
    private val retrofitRepository3 = RepoRepository3()
    private val repoResponse = retrofitRepository3._repoResponse

    fun selectAllRepos(page: Int) {
        retrofitRepository3.selectAllRepos(page)
    }

    fun getRepoResponse(): LiveData<RepoResponse> {
        return repoResponse
    }
}
package com.ssafy.retrofit_2.coroutine_mvvm_version.util

import com.ssafy.retrofit_2.common.config.ApplicationClass
import com.ssafy.retrofit_2.coroutine_mvvm_version.api.RepoApi3

class RetrofitUtil3 {
    companion object {
        val repoService3 = ApplicationClass.retrofit.create(RepoApi3::class.java)
    }
}
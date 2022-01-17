package com.ssafy.retrofit_2.coroutine_version.util

import com.ssafy.retrofit_2.common.config.ApplicationClass
import com.ssafy.retrofit_2.coroutine_version.api.RepoApi2

class RetrofitUtil2 {
    companion object {
        val repoService2 = ApplicationClass.retrofit.create(RepoApi2::class.java)
    }
}
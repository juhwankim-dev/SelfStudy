package com.ssafy.retrofit_2.callback_version.util

import com.ssafy.retrofit_2.callback_version.api.RepoApi1
import com.ssafy.retrofit_2.common.config.ApplicationClass

class RetrofitUtil1 {
    companion object {
        val repoService1 = ApplicationClass.retrofit.create(RepoApi1::class.java)
    }
}
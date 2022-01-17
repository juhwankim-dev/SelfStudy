package com.ssafy.retrofit_2.callback_version.util

interface RetrofitCallback<T> {
    fun onError(code: Int)

    fun onSuccess(code: Int, responseData: T)

    fun onFailure(t: Throwable)
}
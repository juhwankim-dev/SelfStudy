package com.example.selfstudy_kotlin.network

import com.example.selfstudy_kotlin.KakaoNotice
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface JsonPlaceHolderApi {

    @GET("_jxehRd")
    fun boardListPost(): Call<KakaoNotice>
}

object NoticeNetwork {
    private const val baseUrl = "https://pf-wapi.kakao.com/web/profiles/" // 베이스 URL

    private val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getJsonApi(): JsonPlaceHolderApi {
        return retrofit.create(JsonPlaceHolderApi::class.java)
    }
}
package com.example.selfstudy_kotlin.network

import com.example.selfstudy_kotlin.Baemin
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface BaeminApiService {
    @GET("contents?typeCode=notice&size=10")
    fun loadNotice(@Query("page") page: String): Call<Baemin>
}

object BaeminApi {
    private const val baseUrl = "https://ceo.baemin.com/cms/v1/" // 베이스 URL

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun createApi(): BaeminApiService {
        return retrofit.create(
            BaeminApiService::class.java)
    }
}
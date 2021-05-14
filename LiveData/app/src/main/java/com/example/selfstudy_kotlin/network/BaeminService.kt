package com.example.selfstudy_kotlin.network

import com.example.selfstudy_kotlin.Baemin
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface BaeminService {
    @GET("contents?typeCode=notice&size=10")
    fun loadNotice(@Query("page") page: String): Call<Baemin>
}
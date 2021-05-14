package com.example.selfstudy_kotlin.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BaeminClient {
    private const val baseUrl = "https://ceo.baemin.com/cms/v1/" // 베이스 URL
    private val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val service = retrofit.create(BaeminService::class.java)!!
}
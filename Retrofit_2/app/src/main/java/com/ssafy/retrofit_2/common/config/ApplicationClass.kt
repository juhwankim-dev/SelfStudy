package com.ssafy.retrofit_2.common.config

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationClass : Application() {
    private val baseUrl = "https://api.github.com/"

    companion object {
        lateinit var retrofit: Retrofit
        val PER_PAGE = 10
    }

    override fun onCreate() {
        super.onCreate()

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
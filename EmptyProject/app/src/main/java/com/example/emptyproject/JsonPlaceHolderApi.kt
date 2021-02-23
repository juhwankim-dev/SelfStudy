package com.example.emptyproject

import retrofit2.Call
import retrofit2.http.*

/* 뭔지 모르겠지만 걍 똑같이 만들면 되는 듯 하다.*/
interface JsonPlaceHolderApi {

    @GET("/search")
    fun boardListPost(@QueryMap fields: MutableMap<String, String>): Call<Result?>?
}
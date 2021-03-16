package com.example.selfstudy_kotlin.network

import android.text.Html
import com.example.selfstudy_kotlin.KakaoNotice
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import org.json.JSONObject
import org.jsoup.nodes.Document
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import okhttp3.ResponseBody

interface JsonPlaceHolderApi {

    @FormUrlEncoded
    @POST("indexProc.do")
    fun boardListPost(@FieldMap fields: MutableMap<String, String>): Call<ResponseBody>
}

object NoticeNetwork {
    private const val baseUrl = "https://ari.anyang.ac.kr/user/bbs/notice/" // 베이스 URL

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getJsonApi(): JsonPlaceHolderApi {
        return retrofit.create(JsonPlaceHolderApi::class.java)
    }
}



//var gson = GsonBuilder().setLenient().create()
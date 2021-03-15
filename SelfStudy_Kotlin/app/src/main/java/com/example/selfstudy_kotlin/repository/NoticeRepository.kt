package com.example.selfstudy_kotlin.repository

import android.util.Log
import com.example.selfstudy_kotlin.KakaoNotice

import com.example.selfstudy_kotlin.network.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NoticeRepository {
    var _noticeInfo = ArrayList<KakaoNotice>()

    fun requestPost() {

        val call = NoticeNetwork.getJsonApi().boardListPost()

        call?.enqueue(object : Callback<KakaoNotice> {
            override fun onResponse(
                    call: Call<KakaoNotice>,
                    response: Response<KakaoNotice>
            ) {
                if(response.isSuccessful) {
                    Log.v("성공?", "성공?")
                    try {
                        Log.v("뭐들어있어", response.body()!!.hometab.items[0].contents[0].title.text)
                    } catch (e: Exception) {
                        Log.v("실패?", "실패?")
                    }
                }
            }

            override fun onFailure(call: Call<KakaoNotice>, t: Throwable) {
            }
        })
    }
}
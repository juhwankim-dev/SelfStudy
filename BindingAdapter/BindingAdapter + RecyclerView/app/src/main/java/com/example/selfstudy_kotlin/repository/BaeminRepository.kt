package com.example.selfstudy_kotlin.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.selfstudy_kotlin.Baemin
import com.example.selfstudy_kotlin.Data
import com.example.selfstudy_kotlin.ui.MainActivity
import com.example.selfstudy_kotlin.network.BaeminClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BaeminRepository {

    var _baeminNotice = MutableLiveData<Data>()

    fun loadBaeminNotice(page: Int) {
        val call = BaeminClient.service.loadNotice(page.toString())
        call.enqueue(object : Callback<Baemin> {
            override fun onResponse(
                    call: Call<Baemin>,
                    response: Response<Baemin>
            ) {
                if(response.isSuccessful){
                    _baeminNotice.value = response.body()!!.data
                } else {
                    Log.v("로그", "응답 없음")
                }

            }

            override fun onFailure(call: Call<Baemin>, t: Throwable) {
                Log.v("로그", "통신 실패")
            }
        })
    }
}
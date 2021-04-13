package com.example.selfstudy_kotlin.repository

import com.example.selfstudy_kotlin.Baemin
import com.example.selfstudy_kotlin.ui.MainActivity
import com.example.selfstudy_kotlin.network.BaeminClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BaeminRepository {

    fun loadBaeminNotice(page: Int, mCallback: MainActivity) {
        val call = BaeminClient.service.loadNotice(page.toString())

        call.enqueue(object : Callback<Baemin> {
            override fun onResponse(
                    call: Call<Baemin>,
                    response: Response<Baemin>
            ) {
                if(response.isSuccessful){
                    mCallback.loadComplete(response.body()!!.data)
                } else {
                    mCallback.responseIsNotSuccesful(response.code())
                }
            }

            override fun onFailure(call: Call<Baemin>, t: Throwable) {
                mCallback.loadFail()
            }
        })
    }
}
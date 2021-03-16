package com.example.selfstudy_kotlin.repository

import android.util.Log
import com.example.selfstudy_kotlin.MainActivity
import com.example.selfstudy_kotlin.network.NoticeNetwork
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class NoticeRepository{
    private val parameter: MutableMap<String, String> = HashMap()

    fun requestPost(listener: MainActivity) {
        parameter["pageNo"] = "1"
        parameter["schWord"] = " "
        parameter["noneChk"] = "2"

        val call = NoticeNetwork.getJsonApi().boardListPost(parameter)

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                if(response.isSuccessful) {
                    try {

                        var test = response.body()!!.string()
                        listener.update(test)
                    } catch (e: Exception) {

                    }
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

            }
        })



/*        val contentElements = doc.select("td[class=alignL]")
        for ((i, elem) in contentElements.withIndex()) {
            Log.v("${i}번째 값: ", elem.text())
        }*/
    }
}
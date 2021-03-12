package com.example.selfstudy_kotlin.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.selfstudy_kotlin.database.AppDatabase
import com.example.selfstudy_kotlin.database.Todo
import com.example.selfstudy_kotlin.database.TodoDao
import com.example.selfstudy_kotlin.network.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.HashMap

class NoticeRepository {
    private val data: MutableMap<String, String> = HashMap() // Map 선언
    var data2 = MutableLiveData<Result>()

    init {
        data["menuId"] = "23"
        data["bsIdx"] = "61"
        data["bcIdx"] = "0"
        data["page"] = "1"
    }

    fun requestPost() {
        var jsonPlaceHolderApi = NoticeNetwork.retrofit.create(JsonPlaceHolderApi::class.java)
        val call = jsonPlaceHolderApi.boardListPost(data)

        call?.enqueue(object : Callback<Result> {
            override fun onResponse(
                call: Call<Result>,
                response: Response<Result>
            ) {
                if(response.isSuccessful) Log.v("성공", "성공")

                try {
                    data2.value = response.body()
                } catch (e: Exception) {

                }
            }

            /* 응답을 하지 않는다면 */
            override fun onFailure(call: Call<Result>, t: Throwable) {

            }
        })
    }
}

//data class Result(var resultList: Array<ResultList>)
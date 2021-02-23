package com.example.emptyproject

import android.content.Context
import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


class HtmlCrawler(){
    private val BASEURL = "https://webcache.googleusercontent.com" // 베이스 URL
    private var jsonPlaceHolderApi: JsonPlaceHolderApi? = null // JSON 사용하려면 적어야하는거? API

/*    private val retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()*/

    fun requestPost() {
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)
        callAndReq()
    }

    private val gson = GsonBuilder().setLenient().create()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun callAndReq(
    ) {
        //var notices = arrayListOf<NoticeList>()
        val data: MutableMap<String, String> = HashMap() // Map 선언
        data["HOST"] = "sub.anyang.ac.kr"
        data["Content-Length"] = "0"
        data["q"] = "cache:https://sub.anyang.ac.kr/AYUhub_web/support/collegeInfo/coll0101.asp"

        val call: Call<Result?>? = jsonPlaceHolderApi?.boardListPost(data)
        /* .. Call.enquere를.. 정의해줄..거야.. */
        call?.enqueue(object : Callback<Result?> {
            /* 응답을 한다면 */
            /* Result 자료형으로 response를 만들고. 그리고 요청해서 받아온것들을 여기다가 저장할거임. */
            override fun onResponse(
                call: Call<Result?>,
                response: Response<Result?>
            ) {
                Log.v("응답은함?", "@@@@@@@@@@@@@@@@@@")
                /* 응답이 잘 되었다면 response에는 body가 저장되어있는데. 요청한 결과가 저장되어있는거임 */
                /* 그걸 Result형 객체를 하나 만들어서 저장한거임 아래 문장이 */
                if(response.isSuccessful) Log.v("야호", "야호")
                else {
                    Log.v("씨바", response.message())
                    Log.v("씨바", response.errorBody().toString())
                    Log.v("씨바", response.code().toString())
                }

/*                try {
                    val posts = response!!.body()!!.resultList
                    for (post in posts) {
                        Log.v("되나요?", post.calListTableCon + "222222222222222222")
                    }
                } catch (e: Exception) {
                    Log.v("에러먼데", e.stackTrace.toString())
                    Log.v("에러먼데", e.message)
                }*/
            }

            /* 응답을 하지 않는다면 */
            override fun onFailure(call: Call<Result?>, t: Throwable) {
                Log.v("응답안함?", t.printStackTrace().toString())
            }
        })
    }
}
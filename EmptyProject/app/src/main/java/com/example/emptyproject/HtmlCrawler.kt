package com.example.emptyproject

import android.content.Context
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStream
import java.lang.System.load
import java.security.KeyStore
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate
import java.util.HashMap
import javax.net.ssl.*

class HtmlCrawler(){
    private val BASEURL = "https://sub.anyang.ac.kr/AYUhub_web/support/collegeInfo/" // 베이스 URL
    private var jsonPlaceHolderApi: JsonPlaceHolderApi? = null // JSON 사용하려면 적어야하는거? API

    private const val BASE_URL = SERVER_API
    var VERIFY_DOMAIN: String = "*.lottois.info"

/*    private val retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun requestPost() {
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)
        //callAndReq()
    }*/

    fun create(context: Context): ApiService {
        val logger = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val tmf: TrustManagerFactory? = getTrustManagerFactory(context)
        var sslsocket = tmf?.let { getSSLSocketFactory(it) }
        val hostnameVerifier = HostnameVerifier { _, session ->
            HttpsURLConnection.getDefaultHostnameVerifier().run {
            verify(VERIFY_DOMAIN, session) }
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .sslSocketFactory(sslsocket, tmf?.trustManagers?.get(0) as X509TrustManager)
            .hostnameVerifier(hostnameVerifier)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL) .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java) }

    private fun getTrustManagerFactory(context: Context): TrustManagerFactory? {
        // 1. CA 로드
        val cf: CertificateFactory = CertificateFactory.getInstance("X.509")
        val caInput: InputStream = context.resources.openRawResource(R.raw.fullchain)
        val ca: X509Certificate = caInput.use { cf.generateCertificate(it) as X509Certificate }
        // 2. 신뢰할 수있는 CA를 포함하는 키 스토어 생성
        val keyStoreType = KeyStore.getDefaultType()
        val keyStore = KeyStore.getInstance(keyStoreType).apply {
            load(null, null) setCertificateEntry("ca", ca)
        }
        // 3. CA 입력을 신뢰하는 TrustManager 생성
        val tmfAlgorithm: String = TrustManagerFactory.getDefaultAlgorithm()
        val tmf: TrustManagerFactory = TrustManagerFactory.getInstance(tmfAlgorithm).apply {
            init(keyStore)
        }
        return tmf
    }

    private fun getSSLSocketFactory( tmf: TrustManagerFactory ): SSLSocketFactory? {
        //4. TrustManager를 사용하는 SSLContext 생성
        val sslContext: SSLContext = SSLContext.getInstance("TLS")
        sslContext.init(null, tmf.trustManagers, null)
        return sslContext.socketFactory
    }

    /*private fun callAndReq(
    ) {
        //var notices = arrayListOf<NoticeList>()
        val data: MutableMap<String, String> = HashMap() // Map 선언
        data["HOST"] = "sub.anyang.ac.kr"

        val call: Call<Result?>? = jsonPlaceHolderApi?.boardListPost(data)
        *//* .. Call.enquere를.. 정의해줄..거야.. *//*
        call?.enqueue(object : Callback<Result?> {
            *//* 응답을 한다면 *//*
            *//* Result 자료형으로 response를 만들고. 그리고 요청해서 받아온것들을 여기다가 저장할거임. *//*
            override fun onResponse(
                call: Call<Result?>,
                response: Response<Result?>
            ) {
                Log.v("응답은함?", "@@@@@@@@@@@@@@@@@@")
                *//* 응답이 잘 되었다면 response에는 body가 저장되어있는데. 요청한 결과가 저장되어있는거임 *//*
                *//* 그걸 Result형 객체를 하나 만들어서 저장한거임 아래 문장이 *//*
                try {
                    val posts = response!!.body()!!.resultList
                    for (post in posts) {
                        Log.v("되나요?", post.calListTableCon + "222222222222222222")
                    }
                } catch (e: Exception) {

                }
            }

            *//* 응답을 하지 않는다면 *//*
            override fun onFailure(call: Call<Result?>, t: Throwable) {
                Log.v("응답안함?", t.message)
                Log.v("응답안함?", t.stackTrace.toString())
            }
        })
    }*/
}
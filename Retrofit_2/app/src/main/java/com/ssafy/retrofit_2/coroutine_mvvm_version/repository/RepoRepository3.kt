package com.ssafy.retrofit_2.coroutine_mvvm_version.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ssafy.retrofit_2.common.config.ApplicationClass
import com.ssafy.retrofit_2.common.dto.RepoResponse
import com.ssafy.retrofit_2.coroutine_mvvm_version.util.RetrofitUtil3
import kotlinx.coroutines.*

class RepoRepository3 {
    private val TAG = "RepoRepository3_juhwan"
    var _repoResponse = MutableLiveData<RepoResponse>()

    fun selectAllRepos(page: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    RetrofitUtil3.repoService3.selectAllRepos("Java", ApplicationClass.PER_PAGE.toString(), page.toString())
                }

                if(response.isSuccessful) {
                    if(response.body() != null) {
                        _repoResponse.postValue(response.body())
                    }
                } else {
                    Log.d(TAG, "onError: Error Code ${response.code()}")
                }
            } catch (e: Exception) {
                Log.d(TAG, e.message ?: "onFailure")
            }
        }
    }
}
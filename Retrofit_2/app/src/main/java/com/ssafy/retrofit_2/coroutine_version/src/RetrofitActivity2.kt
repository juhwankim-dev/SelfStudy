package com.ssafy.retrofit_2.coroutine_version.src

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssafy.retrofit_2.R
import com.ssafy.retrofit_2.common.adapter.RepoAdapter
import com.ssafy.retrofit_2.common.config.ApplicationClass.Companion.PER_PAGE
import com.ssafy.retrofit_2.coroutine_version.util.RetrofitUtil2.Companion.repoService2
import com.ssafy.retrofit_2.databinding.ActivityRetrofit2Binding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RetrofitActivity2 : AppCompatActivity() {
    private val TAG = "RetrofitActivity2_juhwan"
    private lateinit var binding: ActivityRetrofit2Binding
    lateinit var repoAdapter: RepoAdapter
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit2)

        initView()
        initEvent()
    }

    private fun initView() {
        repoAdapter = RepoAdapter()
        binding.rvRepo.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = repoAdapter
        }
    }

    private fun initEvent() {
        binding.btnNextPage.setOnClickListener {
            selectAllRepos()
        }
    }

    private fun selectAllRepos() {
        lifecycleScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    repoService2.selectAllRepos("Java", PER_PAGE.toString(), page.toString())
                }

                if(response.isSuccessful) {
                    if(response.body() != null) {
                        repoAdapter.loadNextPage(response.body()!!.items)
                        page++
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
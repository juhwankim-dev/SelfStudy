package com.ssafy.retrofit_2.callback_version.src

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssafy.retrofit_2.common.dto.RepoResponse
import com.ssafy.retrofit_2.R
import com.ssafy.retrofit_2.common.adapter.RepoAdapter
import com.ssafy.retrofit_2.callback_version.repository.RepoRepository
import com.ssafy.retrofit_2.databinding.ActivityCallbackVersionBinding
import com.ssafy.retrofit_2.callback_version.util.RetrofitCallback

class CallbackVersionActivity : AppCompatActivity() {
    private val TAG = "CallbackVersionActivity_juhwan_tag"
    private lateinit var binding: ActivityCallbackVersionBinding
    lateinit var repoAdapter: RepoAdapter
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_callback_version)

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
        RepoRepository.selectAllRepos("Java", page, RepoCallback())
    }

    inner class RepoCallback: RetrofitCallback<RepoResponse> {
        override fun onSuccess(
            code: Int,
            responseData: RepoResponse
        ) {
            if(code == 200) {
                repoAdapter.loadNextPage(responseData.items)
                page++
                Log.d(TAG, "onSuccess: ${responseData.items.size} repositories received")
            }
        }

        override fun onFailure(t: Throwable) {
            Log.d(TAG, t.message ?: "onFailure")
        }

        override fun onError(code: Int) {
            Log.d(TAG, "onError: Error Code $code")
        }
    }
}
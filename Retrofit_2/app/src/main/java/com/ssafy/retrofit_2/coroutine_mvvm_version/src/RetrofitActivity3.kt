package com.ssafy.retrofit_2.coroutine_mvvm_version.src

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssafy.retrofit_2.R
import com.ssafy.retrofit_2.common.adapter.RepoAdapter
import com.ssafy.retrofit_2.databinding.ActivityRetrofit3Binding

class RetrofitActivity3 : AppCompatActivity() {
    private val retrofitViewModel: RetrofitViewModel by viewModels()
    private lateinit var binding: ActivityRetrofit3Binding
    lateinit var repoAdapter: RepoAdapter
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit3)

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
            retrofitViewModel.selectAllRepos(page)
        }

        retrofitViewModel.getRepoResponse().observe(this, {
            repoAdapter.loadNextPage(it.items)
            page++
        })
    }
}
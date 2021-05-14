package com.example.selfstudy_kotlin.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.selfstudy_kotlin.Data
import com.example.selfstudy_kotlin.databinding.ActivityMainBinding
import com.example.selfstudy_kotlin.repository.BaeminRepository
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val model: MainViewModel by viewModels()
    private lateinit var noticeAdapter: NoticeAdapter
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvBaeminNotice.apply {
            binding.rvBaeminNotice.layoutManager = LinearLayoutManager(context)
            noticeAdapter = NoticeAdapter()
            binding.rvBaeminNotice.adapter = noticeAdapter
        }
        model.loadBaeminNotice(page)

        model.getAll().observe(this, Observer{ notice ->
            noticeAdapter.setList(notice.content)
            noticeAdapter.notifyDataSetChanged()
        })

        binding.btnLoadNextPage.setOnClickListener {
            model.loadBaeminNotice(++page)
        }
    }
}

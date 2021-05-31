package com.example.selfstudy_kotlin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.selfstudy_kotlin.databinding.ActivityMainBinding
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.selfstudy_kotlin.R

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val model: MainViewModel by viewModels()
    private lateinit var noticeAdapter: NoticeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = model
        binding.lifecycleOwner = this
    }
}

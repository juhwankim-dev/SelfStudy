package com.ssafy.retrofit_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ssafy.retrofit_2.callback_version.src.CallbackVersionActivity
import com.ssafy.retrofit_2.coroutine_version.src.CoroutineVersionActivity
import com.ssafy.retrofit_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initEvent()
    }

    fun initEvent() {
        binding.btnCallbackPage.setOnClickListener {
            startActivity(Intent(this, CallbackVersionActivity::class.java))
        }

        binding.btnCoroutinePage.setOnClickListener {
            startActivity(Intent(this, CoroutineVersionActivity::class.java))
        }
    }
}
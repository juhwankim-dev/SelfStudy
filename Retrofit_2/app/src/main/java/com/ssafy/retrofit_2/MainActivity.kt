package com.ssafy.retrofit_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ssafy.retrofit_2.callback_version.src.RetrofitActivity1
import com.ssafy.retrofit_2.coroutine_mvvm_version.src.RetrofitActivity3
import com.ssafy.retrofit_2.coroutine_version.src.RetrofitActivity2
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
            startActivity(Intent(this, RetrofitActivity1::class.java))
        }

        binding.btnCoroutinePage.setOnClickListener {
            startActivity(Intent(this, RetrofitActivity2::class.java))
        }

        binding.btnCoroutineMvvmPage.setOnClickListener {
            startActivity(Intent(this, RetrofitActivity3::class.java))
        }
    }
}
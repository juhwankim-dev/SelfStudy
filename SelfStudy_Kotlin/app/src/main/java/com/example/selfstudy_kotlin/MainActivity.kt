package com.example.selfstudy_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.selfstudy_kotlin.databinding.ActivityMainBinding
import com.example.selfstudy_kotlin.repository.NoticeRepository

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var test = NoticeRepository()
        test.requestPost()
    }

}

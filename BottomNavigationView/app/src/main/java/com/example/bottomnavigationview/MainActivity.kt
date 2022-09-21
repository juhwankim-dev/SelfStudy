package com.example.bottomnavigationview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.example.bottomnavigationview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initEvent()
    }

    private fun initEvent() {
        binding.button.setOnClickListener {
            startActivity(Intent(this, NavigationExample1Actvitiy::class.java))
        }
        binding.button2.setOnClickListener {
            startActivity(Intent(this, NavigationExample2Activity::class.java))
        }
        binding.button3.setOnClickListener {
            startActivity(Intent(this, NavigationExample3Activity::class.java))
        }
    }
}
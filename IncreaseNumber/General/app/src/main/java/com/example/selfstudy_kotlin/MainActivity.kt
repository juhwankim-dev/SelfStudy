package com.example.selfstudy_kotlin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtNumber = findViewById<TextView>(R.id.txt_number)
        var btnIncrease = findViewById<Button>(R.id.btn_increase)

        btnIncrease.setOnClickListener {
            txtNumber.text = number++.toString()
        }
    }
}

package com.example.selfstudy_kotlin

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var number = 0

    fun increase() {
        number++
    }

    fun getNumber(): String {
        return number.toString()
    }
}
package com.example.selfstudy_kotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var number = MutableLiveData<Int>()
    init {
        number.value = 0
    }

    fun increase() {
        number.value = number.value?.plus(1)
    }

    fun getNumber(): MutableLiveData<Int> {
        return number
    }
}
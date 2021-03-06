package com.example.selfstudy_kotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel(): ViewModel() {
    var height = MutableLiveData<Int>()

    init {
        height.value = 170
    }

    fun increase() {
        height.value = height.value?.plus(1)
    }

    fun decrease() {
        height.value = height.value?.plus(1)
    }
}
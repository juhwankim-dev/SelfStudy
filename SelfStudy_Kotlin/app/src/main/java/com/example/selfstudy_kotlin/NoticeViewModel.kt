package com.example.selfstudy_kotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.selfstudy_kotlin.network.Result
import com.example.selfstudy_kotlin.network.ResultList
import com.example.selfstudy_kotlin.repository.NoticeRepository

class NoticeViewModel : ViewModel() {
    private val repository = NoticeRepository()

    fun requestPost(){
        repository.requestPost()
    }

    fun getAll(): MutableLiveData<Result> {
        return repository.data2
    }
}


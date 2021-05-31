package com.example.selfstudy_kotlin.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.selfstudy_kotlin.Data
import com.example.selfstudy_kotlin.repository.BaeminRepository

class MainViewModel : ViewModel() {
    private var page = 1
    private val baeminRepository = BaeminRepository()

    private val baeminNotice: LiveData<Data>
        get() = baeminRepository._baeminNotice

    init {
        loadBaeminNotice()
    }

    fun loadBaeminNotice(){
        Log.v("로그", "$page 페이지를 불러옴")
        baeminRepository.loadBaeminNotice(page++)
    }

    fun getAll(): LiveData<Data> {
        return baeminNotice
    }
}
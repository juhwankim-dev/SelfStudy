package com.example.selfstudy_kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val baeminRepository = BaeminRepository()
    private val notice: LiveData<Data>
        get() = baeminRepository._notice

    fun loadBaeminNotice(page: Int){
        baeminRepository.loadBaeminNotice(page)
    }

    fun getAll(): LiveData<Data> {
        return notice
    }
}
package com.example.selfstudy_kotlin.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.selfstudy_kotlin.Data
import com.example.selfstudy_kotlin.repository.BaeminRepository

class MainViewModel : ViewModel() {
    private val baeminRepository = BaeminRepository()

    private val baeminNotice: LiveData<Data>
        get() = baeminRepository._baeminNotice

    fun loadBaeminNotice(page: Int){
        baeminRepository.loadBaeminNotice(page)
    }

    fun getAll(): LiveData<Data> {
        return baeminNotice
    }
}
package com.example.selfstudy_kotlin

interface CompletionListener {
    fun loadComplete(data: Data)
    fun responseIsNotSuccesful(code: Int)
    fun loadFail()
}
package com.example.selfstudy_kotlin

import com.google.gson.annotations.SerializedName


data class Baemin(val data: Data)

data class Data(val content: ArrayList<Content>)

data class Content(
    @SerializedName("title")
    val title: String,
    @SerializedName("created")
    val date: String
)

package com.example.selfstudy_kotlin

import com.google.gson.annotations.SerializedName

data class Content(
        @SerializedName("title")
        val title: String,
        @SerializedName("created")
        val date: String
)
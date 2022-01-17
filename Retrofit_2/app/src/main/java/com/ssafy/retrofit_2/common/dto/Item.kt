package com.ssafy.retrofit_2.common.dto

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("full_name") val full_name: String,
    @SerializedName("language") val language: String
)
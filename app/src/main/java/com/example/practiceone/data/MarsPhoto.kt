package com.example.practiceone.data

import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName

data class MarsPhoto(
    val id: String,
    @SerializedName(value = "img_src") val imgSrcUrl: String
)

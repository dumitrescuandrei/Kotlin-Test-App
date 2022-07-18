package com.example.practiceone.model

import android.util.Base64
import androidx.annotation.StringRes

data class Affirmation(
    val base64Image: String,
    val linkToArticle: String = "https://www.jwst.nasa.gov/"

)
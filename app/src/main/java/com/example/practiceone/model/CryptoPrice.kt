package com.example.practiceone.model

import com.google.gson.annotations.SerializedName

data class Data(

    @SerializedName("data") val data: List<Crypto>?
)

data class Crypto (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("quote") val quotePrice: QuoteDto
)
data class QuoteDto(
    @SerializedName("USD") val usdDto: UsdDto
)

data class UsdDto(
    @SerializedName("price") val price: Float
)
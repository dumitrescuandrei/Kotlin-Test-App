package com.example.practiceone.network

import com.example.practiceone.model.Crypto
import com.example.practiceone.model.Data
import com.google.gson.GsonBuilder
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

private const val apiKey = "801f5309-9ab7-407b-88df-49c17db783ca"

private const val BASE_URL = "https://pro-api.coinmarketcap.com/"

private val gson = GsonBuilder().create()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .build()

class CryptoResponse {

}

interface CryptoService {
    @Headers("X-CMC_PRO_API_KEY: $apiKey")
    @GET("v1/cryptocurrency/listings/latest?start=1&limit=1&convert=USD")
    suspend fun getData(): Response<Data>
}

object CryptoApi {
    val retrofitService: CryptoService by lazy { retrofit.create(CryptoService::class.java) }
}
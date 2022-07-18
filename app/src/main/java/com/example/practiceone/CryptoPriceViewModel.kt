package com.example.practiceone

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practiceone.model.Data
import com.example.practiceone.network.CryptoApi
import kotlinx.coroutines.launch
import retrofit2.Response

class CryptoPriceViewModel : ViewModel() {
    private val _latestData = MutableLiveData<Response<Data>>()

    fun latestData(): LiveData<Response<Data>> = _latestData

    init {
        getLatestPrice()
    }

    private fun getLatestPrice() {
        viewModelScope.launch {
            try {
                _latestData.value = CryptoApi.retrofitService.getData()
            } catch (e: Exception) {

            }
        }
    }

}
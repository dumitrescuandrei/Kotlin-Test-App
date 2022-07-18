package com.example.practiceone

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practiceone.data.MarsPhoto
import com.example.practiceone.network.MarsApi
import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.properties.Delegates

class RemoteViewModel : ViewModel() {

    private val _photos = MutableLiveData<List<MarsPhoto>>()
    val photos: LiveData<List<MarsPhoto>> = _photos


//    var photosRemake by Delegates.observable("initial value") { _, old, new -> println("something")}
//    lateinit var photosRemake: List<MarsPhoto>



    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {

//        CoroutineScope(Dispatchers.IO).launch {
//            _photos.value = withContext(Dispatchers.IO) {
//                MarsApi.retrofitService.getPhotos()
//            }
//        }

        viewModelScope.launch {
            try {
                _photos.value = MarsApi.retrofitService.getPhotos()

            } catch (e: Exception) {
                _photos.value = arrayListOf()
            }
        }
    }
}
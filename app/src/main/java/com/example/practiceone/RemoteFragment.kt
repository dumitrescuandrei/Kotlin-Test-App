package com.example.practiceone

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import com.example.practiceone.adapter.PhotoGridAdapter
import com.example.practiceone.data.MarsPhoto
import com.example.practiceone.databinding.RemoteFragmentBinding
import com.example.practiceone.network.MarsApi
import io.reactivex.Observable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class RemoteFragment : Fragment() {

    private val viewModel: RemoteViewModel by viewModels()

    private lateinit var binding: RemoteFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RemoteFragmentBinding.inflate(inflater, container, false)


        viewModel.photos.observe(viewLifecycleOwner){
            value -> binding.rvRemote.adapter = PhotoGridAdapter(context, value)
        }


//        Observable.just(viewModel.photos)
//            .subscribe(
//                { value -> binding.rvRemote.adapter = PhotoGridAdapter(context, value) }
//            )
//        binding.rvRemote.adapter = PhotoGridAdapter(context, viewModel.photosRemake)


        return binding.root
    }






//    suspend fun getMarsPhotos(): List<MarsPhoto> {
//        return MarsApi.retrofitService.getPhotos()
//
//    }
}
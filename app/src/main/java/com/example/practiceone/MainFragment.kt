package com.example.practiceone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.practiceone.databinding.MainFragmentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = MainFragmentBinding.inflate(inflater)

        binding.jamesWebbButton.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToJamesWebbFragment())
        }
        binding.remoteButton.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch { findNavController().navigate(MainFragmentDirections.actionMainFragmentToRemoteFragment()) }

        }

        binding.bitcoinButton.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToBitcoinPriceFragment())
        }

        return binding.root

    }

}
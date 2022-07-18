package com.example.practiceone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.practiceone.adapter.JamesAdapter
import com.example.practiceone.data.JamesImagesDataset
import com.example.practiceone.databinding.JamesWebbFragmentBinding


class JamesWebbFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = JamesWebbFragmentBinding.inflate(inflater)

        binding.rvWebb.adapter = JamesAdapter(container?.context, JamesImagesDataset().loadAffirmations())


        binding.rvWebb.setHasFixedSize(true)

        binding.rvWebbToMainButton.setOnClickListener {
            findNavController().navigate(JamesWebbFragmentDirections.actionJamesWebbFragmentToMainFragment())
        }
        return binding.root
    }
}
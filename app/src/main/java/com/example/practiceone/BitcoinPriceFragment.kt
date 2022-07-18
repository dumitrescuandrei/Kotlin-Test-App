package com.example.practiceone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.practiceone.databinding.BitcoinPriceFragmentBinding

class BitcoinPriceFragment : Fragment() {

    private val viewModel: CryptoPriceViewModel by activityViewModels()

    private var binding: BitcoinPriceFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = BitcoinPriceFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        viewModel.latestData().observe(viewLifecycleOwner) {
            value -> fragmentBinding.bitcoinPrice.text = resources.getString(R.string.bitcoinPrice, viewModel.latestData().value?.body()?.data?.get(0)?.quotePrice?.usdDto?.price?.toInt())
        }

        return fragmentBinding.root
    }


}
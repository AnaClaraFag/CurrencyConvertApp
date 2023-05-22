package com.example.currencyconvert.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.currencyconvert.R
import com.example.currencyconvert.databinding.FragmentCurrencyValueBinding
import com.example.currencyconvert.databinding.FragmentHistoryCurrencyValueBinding

class HistoryCurrencyValueFragment : Fragment() {

    private var _binding: FragmentHistoryCurrencyValueBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryCurrencyValueBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}
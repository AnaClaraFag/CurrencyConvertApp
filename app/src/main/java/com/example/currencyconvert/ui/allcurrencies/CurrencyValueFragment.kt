package com.example.currencyconvert.ui.allcurrencies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyconvert.R
import com.example.currencyconvert.core.data.response.toCurrencyData
import com.example.currencyconvert.core.extensions.repeatWhenStarted
import com.example.currencyconvert.databinding.FragmentCurrencyValueBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CurrencyValueFragment : Fragment() {

    private var _binding: FragmentCurrencyValueBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CurrenciesValueViewModel by viewModels()

    private var adapter = CurrencyValueListAdapter(hashMapOf())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCurrencyValueBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fragment = this
        binding.rvCurrencyListValue.adapter = adapter
        observers()
    }

    private fun observers() {
        viewLifecycleOwner.repeatWhenStarted {
            launch {
                viewModel.isLoading.collect { isVisible ->
                    binding.progressBar.apply {
                        visibility = if (isVisible) View.VISIBLE
                        else View.GONE
                    }
                    binding.currencySpinner.apply {
                        visibility = if (isVisible) View.GONE
                        else View.VISIBLE
                    }
                    binding.rvCurrencyListValue.apply {
                        visibility = if (isVisible) View.GONE
                        else View.VISIBLE
                    }
                }
            }
            launch {
                viewModel.currencyNameList.collect { currencyList ->
                    val currencyNameListAdapter = ArrayAdapter(
                        requireContext(),
                        R.layout.currency_name_item,
                        currencyList
                    )
                    binding.currencySpinner.adapter = currencyNameListAdapter
                    binding.currencySpinner.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                val newItem = binding.currencySpinner.selectedItemPosition
                                viewModel.currencySelected.value = currencyList[newItem]
                            }

                            override fun onNothingSelected(p0: AdapterView<*>?) {
                            }

                        }
                }
            }
            launch {
                viewModel.currencySelected.collect {
                    if (it != null) viewModel.getCurrencyValueAroundTheWorld(it.description)
                    else {
                        Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
                    }
                }
            }

            launch {
                viewModel.currenciesList.collect {
                    if (it != null) {
                        val rates = it.rates.toCurrencyData()
                        adapter.hashMapOfSymbolAndValue = rates
                    }
                }
            }
        }
    }
}

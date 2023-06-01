package com.example.currencyconvert.ui.allcurrencies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.currencyconvert.R
import com.example.currencyconvert.core.data.response.toCurrencyData
import com.example.currencyconvert.core.extensions.repeatWhenStarted
import com.example.currencyconvert.core.utils.Validators
import com.example.currencyconvert.databinding.FragmentCurrencyValueBinding
import com.example.currencyconvert.ui.CurrenciesValueViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CurrencyValueFragment : Fragment() {

    private var _binding: FragmentCurrencyValueBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CurrenciesValueViewModel by activityViewModels()

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
                    binding.progressBarCurrencyListName.apply {
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
                    val selectedIndex = viewModel.currencyNameList.value.indexOf(it)
                    if (selectedIndex != -1) {
                        binding.currencySpinner.setSelection(selectedIndex)
                    }
                    if (it != null) viewModel.getCurrencyValueAroundTheWorld(it.description)
                }
            }

            launch {
                viewModel.currenciesList.collect {
                    if (it != null) {
                        val rates = it.rates.toCurrencyData()
                        val selectedCurrency = viewModel.currencySelected.value?.description
                        if (Validators.validateCurrencySelected(
                                selectedCurrency ?: "USD",
                                rates.toList()
                            )
                        ) {
                            rates.remove(selectedCurrency)
                            adapter.setDataSet(rates)
                        }
                    }
                }
            }
            launch {
                viewModel.currencyValueIsLoading.collect { isLoading ->
                    if (isLoading) {
                        binding.rvCurrencyListValue.visibility = View.GONE
                        binding.progressBarCurrencyValueList.visibility = View.VISIBLE
                    } else {
                        binding.rvCurrencyListValue.visibility = View.VISIBLE
                        binding.progressBarCurrencyValueList.visibility = View.GONE
                    }

                }
            }
        }
    }


}

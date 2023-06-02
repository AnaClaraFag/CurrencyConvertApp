package com.example.currencyconvert.ui.converter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.currencyconvert.R
import com.example.currencyconvert.core.data.models.CurrencySymbols
import com.example.currencyconvert.core.extensions.repeatWhenStarted
import com.example.currencyconvert.core.utils.Validators
import com.example.currencyconvert.databinding.FragmentCurrencyConverterBinding
import com.example.currencyconvert.ui.CurrenciesValueViewModel
import kotlinx.coroutines.launch


class CurrencyConverterFragment : Fragment() {

    private var _binding: FragmentCurrencyConverterBinding? = null
    val binding get() = _binding!!
    private val viewModel: CurrenciesValueViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCurrencyConverterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragment = this

        setTextWatcherUserInput()
        observeUserInputs()
    }


    private fun observeUserInputs() {
        viewLifecycleOwner.repeatWhenStarted {
            launch {
                viewModel.currencyNameList.collect { currencyList ->
                    val currencyNameListAdapter = ArrayAdapter(
                        requireContext(),
                        R.layout.currency_name_item,
                        currencyList
                    )
                    binding.currencyFrom.adapter = currencyNameListAdapter
                    binding.currencyTo.adapter = currencyNameListAdapter
                    getCurrencySymbol(currencyList)

                }
            }
            launch {
                viewModel.valueConverted.collect { valueResponse ->
                    binding.valueConvertedTv.text = valueResponse
                }
            }
            launch {
                viewModel.referenceDateConversion.collect {
                    binding.tvDate.text = it
                }
            }
        }
    }

    private fun getCurrencySymbol(listOfCurrencySymbols: ArrayList<CurrencySymbols>) {
        val viewCurrencyTo = binding.currencyTo
        viewCurrencyTo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val newItem = viewCurrencyTo.selectedItemPosition
                viewModel.toCurrency.value = listOfCurrencySymbols[newItem]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}

        }
        val viewCurrencyFrom = binding.currencyFrom
        viewCurrencyFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val newItem = viewCurrencyFrom.selectedItemPosition
                viewModel.fromCurrency.value = listOfCurrencySymbols[newItem]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}

        }
    }


    private fun setTextWatcherUserInput() {
        binding.valueToConvert.doAfterTextChanged {
            if (Validators.validateValueUserInput(it.toString())) {
                binding.buttonConvert.isEnabled = true
                viewModel.amountToConvert.value = it.toString()
            } else {
                binding.valueToConvert.setError("You need to enter valid data")
            }
            if (it.isNullOrBlank()) {
                binding.valueToConvert.error = null
                binding.buttonConvert.isEnabled = false
                viewModel.valueConverted.value = "0"
            }

        }
    }

    fun convertCurrency() {
        viewModel.getCurrencyConversion()
    }


}
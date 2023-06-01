package com.example.currencyconvert.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconvert.core.data.models.CurrencySymbols
import com.example.currencyconvert.core.data.repository.CurrencyRepository
import com.example.currencyconvert.core.data.response.LatestRatesResponse
import com.example.currencyconvert.core.extensions.doOnError
import com.example.currencyconvert.core.extensions.doOnSuccess
import com.example.currencyconvert.core.utils.convertDoubleToMonetaryFormat
import com.example.currencyconvert.core.utils.formatDate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrenciesValueViewModel @Inject constructor(
    private val repository: CurrencyRepository
) : ViewModel() {

    val currenciesList = MutableStateFlow<LatestRatesResponse?>(null)
    val currencyNameList = MutableStateFlow<ArrayList<CurrencySymbols>>(arrayListOf())
    val currencySelected = MutableStateFlow<CurrencySymbols?>(null)
    val isLoading = MutableStateFlow(false)
    val currencyValueIsLoading = MutableStateFlow(false)

    val fromCurrency = MutableStateFlow<CurrencySymbols?>(null)
    val toCurrency = MutableStateFlow<CurrencySymbols?>(null)
    val amountToConvert = MutableStateFlow<String?>(null)
    val valueConverted = MutableStateFlow<String?>(null)
    val referenceDateConversion = MutableStateFlow<String?>(null)



    init {
        getAllCurrencyNamesList()
    }

    fun getAllCurrencyNamesList() {
        viewModelScope.launch {
            isLoading.value = true
            repository.getCurrencyNamesAndSymbols().doOnSuccess {
                currencyNameList.value = it
                if (currencySelected.value == null) {
                    currencySelected.value = it[0]
                }
                isLoading.value = false
            }.doOnError {
                Log.e("ListOfCoinsNames", "${this.error}")
            }
        }
    }

    fun getCurrencyValueAroundTheWorld(symbol: String): MutableStateFlow<LatestRatesResponse?> {
        currencyValueIsLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllCurrenciesValue(symbol).doOnSuccess {
                currenciesList.value = it
                currencyValueIsLoading.value = false
            }
                .doOnError {
                    Log.e("ValueCurrencyRequest", "${this.error}")
                    currencyValueIsLoading.value = false
                }
        }
        return currenciesList
    }

    fun getCurrencyConversion() {
        viewModelScope.launch {
            repository.getCurrencyConversion(
                fromCurrency.value?.description ?: "USD",
                toCurrency.value?.description ?: "EUR",
                amountToConvert.value ?: "0"
            ).doOnSuccess {
                valueConverted.value = it.result.convertDoubleToMonetaryFormat()
                referenceDateConversion.value = formatDate(it.date)
            }
        }
    }


}
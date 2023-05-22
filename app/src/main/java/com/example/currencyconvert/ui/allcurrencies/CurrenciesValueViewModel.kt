package com.example.currencyconvert.ui.allcurrencies

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconvert.core.data.models.CurrencyData
import com.example.currencyconvert.core.data.models.CurrencySymbols
import com.example.currencyconvert.core.data.repository.CurrencyRepository
import com.example.currencyconvert.core.data.response.LatestRatesResponse
import com.example.currencyconvert.core.extensions.doOnError
import com.example.currencyconvert.core.extensions.doOnSuccess
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

    val listOfCurrencyData = ArrayList<CurrencyData>()

    init {
        getAllCurrencyNamesList()
    }

    private fun getAllCurrencyNamesList() {
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
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllCurrenciesValue(symbol).doOnSuccess {
                currenciesList.value = it
            }
                .doOnError {
                    Log.e("ValueCurrencyRequest", "${this.error}")
                }
        }
        return currenciesList
    }


}
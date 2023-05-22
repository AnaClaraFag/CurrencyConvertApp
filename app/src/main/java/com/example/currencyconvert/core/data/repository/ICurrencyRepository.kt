package com.example.currencyconvert.core.data.repository

import com.example.currencyconvert.core.data.models.CurrencySymbols
import com.example.currencyconvert.core.data.response.LatestRatesResponse
import com.haroldadmin.cnradapter.NetworkResponse

interface ICurrencyRepository {

    suspend fun getAllCurrenciesValue(symbol: String): NetworkResponse<LatestRatesResponse, String>

    suspend fun getCurrencyNamesAndSymbols(): NetworkResponse<ArrayList<CurrencySymbols>, String>
}
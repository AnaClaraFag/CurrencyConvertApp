package com.example.currencyconvert.core.data.repository

import com.example.currencyconvert.core.api.CurrencyApi
import com.example.currencyconvert.core.data.models.CurrencySymbols
import com.example.currencyconvert.core.data.response.CurrencyConvertedResponse
import com.example.currencyconvert.core.data.response.LatestRatesResponse
import com.example.currencyconvert.core.data.response.toCurrencyDataList
import com.example.currencyconvert.core.extensions.convert
import com.haroldadmin.cnradapter.NetworkResponse
import javax.inject.Inject

class CurrencyRepository @Inject constructor(
    private val api: CurrencyApi
) : ICurrencyRepository {
    override suspend fun getAllCurrenciesValue(symbol: String): NetworkResponse<LatestRatesResponse, String> {
        return api.getAllCurrenciesValue(symbol)
    }

    override suspend fun getCurrencyNamesAndSymbols(): NetworkResponse<ArrayList<CurrencySymbols>, String> {
        return api.getCurrencyNamesAndSymbols().convert {
            it.symbols.toCurrencyDataList()
        }
    }

    override suspend fun getCurrencyConversion(
        from: String,
        to: String,
        amount: String
    ): NetworkResponse<CurrencyConvertedResponse, String> {
        return api.convertFromTo(
            from = from,
            to = to,
            amount = amount
        )
    }
}
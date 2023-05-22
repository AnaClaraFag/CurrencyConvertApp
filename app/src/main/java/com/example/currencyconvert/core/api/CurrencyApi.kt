package com.example.currencyconvert.core.api

import com.example.currencyconvert.core.data.response.CurrencySymbolsResponse
import com.example.currencyconvert.core.data.response.LatestRatesResponse
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {

    @GET("latest")
    suspend fun getAllCurrenciesValue(
        @Query("base") base:String
    ): NetworkResponse<LatestRatesResponse, String>

    @GET("symbols")
    suspend fun getCurrencyNamesAndSymbols(
    ): NetworkResponse<CurrencySymbolsResponse, String>

}
package com.example.currencyconvert.core.data.response

data class LatestRatesResponse(
    val base: String,
    val date: String,
    val motd: Motd,
    val rates: Rates,
    val success: Boolean
)
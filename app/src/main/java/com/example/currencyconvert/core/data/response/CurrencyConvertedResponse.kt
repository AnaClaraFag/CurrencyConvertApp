package com.example.currencyconvert.core.data.response

data class CurrencyConvertedResponse(
    val date: String,
    val historical: Boolean,
    val info: Info,
    val motd: MotdXX,
    val query: Query,
    val result: Double,
    val success: Boolean
)
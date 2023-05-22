package com.example.currencyconvert.core.data.response

data class CurrencySymbolsResponse(
    val motd: MotdX,
    val success: Boolean,
    val symbols: Symbols
)
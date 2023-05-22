package com.example.currencyconvert.core.data.models

data class CurrencySymbols(
    val description: String,
    val code: String
){
    override fun toString(): String = "$code - $description"
}

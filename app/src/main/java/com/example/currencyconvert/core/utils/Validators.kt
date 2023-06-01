package com.example.currencyconvert.core.utils

import com.example.currencyconvert.core.data.response.Rates

object Validators {

    /*
    the input is not valid if value is empty or 0
     */

    fun validateValueUserInput(
        valueToConvert: String
    ): Boolean{
        return !(valueToConvert == "0" || valueToConvert.isEmpty())
    }

    /*
    the currency selected by user doesn't appear on list of values
     */

    val fakeList = listOf("USD", "EUR", "BRL", "BIC")

    fun validateCurrencySelected(
        currencySelected : String,
        currencyList: List<Any>
    ): Boolean{
        return currencyList.contains(currencySelected)
    }
}
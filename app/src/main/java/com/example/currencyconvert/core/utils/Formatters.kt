package com.example.currencyconvert.core.utils

import java.text.DecimalFormat
import java.util.Locale

fun Double.convertDoubleToMonetaryFormat(): String {
    val formatter = (DecimalFormat.getInstance(Locale("pt", "BR"))
            as DecimalFormat).apply {
        applyPattern("#,##0.00")
    }
    return formatter.format(this)
}
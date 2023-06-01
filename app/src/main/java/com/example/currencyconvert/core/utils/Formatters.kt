package com.example.currencyconvert.core.utils

import android.annotation.SuppressLint
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Locale

fun Double.convertDoubleToMonetaryFormat(): String {
    val formatter = (DecimalFormat.getInstance(Locale("pt", "BR"))
            as DecimalFormat).apply {
        applyPattern("#,##0.00")
    }
    return formatter.format(this)
}
@SuppressLint("SimpleDateFormat")
fun formatDate(date: String?): String {
    return if (date != null) {
        val simpleDate = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
        val inputDate = SimpleDateFormat("yyyy-MM-dd")
        val dateToDate = date.let { inputDate.parse(it) }
        return simpleDate.format(dateToDate)
    } else {
        "0000-00-00T00:00:00Z"
    }
}

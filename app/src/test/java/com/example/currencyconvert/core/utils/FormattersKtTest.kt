package com.example.currencyconvert.core.utils

import org.junit.Assert.*

import org.junit.Test

class FormattersKtTest {

    @Test
    fun `check if this function convert number to monetary format`() {
        val result = 1.00.convertDoubleToMonetaryFormat()
        assertEquals("1,00", result)

    }

    @Test
    fun `check if this format a string in a date string in brazil format`() {
        val result = formatDate("2023-03-10T00:00:00Z")
        assertEquals("03/10/2023", result)
    }
}
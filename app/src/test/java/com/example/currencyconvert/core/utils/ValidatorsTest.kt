package com.example.currencyconvert.core.utils


import org.junit.Assert.assertEquals
import org.junit.Test

class ValidatorsTest {

    @Test
    fun `empty user value input returns false`() {
        val result = Validators.validateValueUserInput(
            "0"
        )
        assertEquals(false, result)

    }

    @Test
    fun `check if currency selected by user is on the list`(){
        val result = Validators.validateCurrencySelected(
            "USD",
            Validators.fakeList
        )

        assertEquals(true, result)
    }
}
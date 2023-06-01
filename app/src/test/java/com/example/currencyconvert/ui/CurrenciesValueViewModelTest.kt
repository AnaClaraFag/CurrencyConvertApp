package com.example.currencyconvert.ui

import app.cash.turbine.test
import com.example.currencyconvert.MainDispatcherRule
import com.example.currencyconvert.core.data.models.CurrencySymbols
import com.example.currencyconvert.core.data.repository.CurrencyRepository
import com.haroldadmin.cnradapter.NetworkResponse
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.mockk
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.kotlin.whenever
import javax.inject.Inject

@HiltAndroidTest
@RunWith(JUnit4::class)
class CurrenciesValueViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val instantTaskExecutorRule = MainDispatcherRule()

    @Inject
    private var repository= mockk<CurrencyRepository>()
    private lateinit var viewModel: CurrenciesValueViewModel

    @Before
    fun setup() {
        viewModel = CurrenciesValueViewModel(repository)
    }


    @Test
    fun `test currency name list request and update`() =

        runTest(testDispatcher) {
            val currencySymbols =
                arrayListOf(CurrencySymbols("USD", "United States Dollar"))
            val networkResponse = currencySymbols
                    as NetworkResponse<ArrayList<CurrencySymbols>, String>

            whenever(
                repository.getCurrencyNamesAndSymbols()
            ).thenReturn(networkResponse)


            viewModel.currencyNameList.test {
                skipItems(1)
                val value = awaitItem()
                assert(value.isNotEmpty())
            }


        }

    @Test
    fun getCurrencyNameList() {
    }

    @Test
    fun getCurrencySelected() {
    }

    @Test
    fun getValueConverted() {
    }

    @Test
    fun getCurrencyValueAroundTheWorld() {
    }

    @Test
    fun getCurrencyConversion() {
    }


}
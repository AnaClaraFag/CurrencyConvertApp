package com.example.currencyconvert.ui

import app.cash.turbine.test
import com.example.currencyconvert.MainDispatcherRule
import com.example.currencyconvert.core.data.models.CurrencySymbols
import com.example.currencyconvert.core.data.repository.ICurrencyRepository
import com.example.currencyconvert.core.data.response.LatestRatesResponse
import com.example.currencyconvert.core.data.response.Motd
import com.haroldadmin.cnradapter.NetworkResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class CurrenciesValueViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val instantTaskExecutorRule = MainDispatcherRule()

    private var repository = mock<ICurrencyRepository>()
    private lateinit var viewModel: CurrenciesValueViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = CurrenciesValueViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test currency name list request and update`() =

        runTest(testDispatcher) {
            val currencySymbols =
                arrayListOf(CurrencySymbols("USD", "United States Dollar"))
            val response: Response<String> = Response.success("")
            val networkResponse: NetworkResponse<ArrayList<CurrencySymbols>, String> =
                NetworkResponse.Success(currencySymbols, response)


            whenever(
                repository.getCurrencyNamesAndSymbols()
            ).thenReturn(networkResponse)

            viewModel.getAllCurrencyNamesList()

            viewModel.currencyNameList.test {
                skipItems(1)
                val value = awaitItem()
                assert(value.isNotEmpty())
            }
        }

    @Test
    fun `check if currency selection changes`() {

    }

    @Test
    fun getValueConverted() {
    }

    @Test
    fun getCurrencyValueAroundTheWorld() {

        runTest(testDispatcher) {
            val baseMock = "USD"
            val latestRatesResponseMock = LatestRatesResponse(
                "USD",
                "10/10/1999",
                Motd("", ""),
                null,
                true
            )

            val response: Response<String> = Response.success("")
            val networkResponse: NetworkResponse<LatestRatesResponse, String> =
                NetworkResponse.Success(latestRatesResponseMock, response)


            whenever(
                repository.getAllCurrenciesValue(baseMock)
            ).thenReturn(networkResponse)
            viewModel.getCurrencyValueAroundTheWorld(baseMock)

            viewModel.currenciesList.test {
                skipItems(1)
                val value = awaitItem()
                assertEquals(value, latestRatesResponseMock)
            }

        }
    }

    @Test
    fun getCurrencyConversion() {
    }


}
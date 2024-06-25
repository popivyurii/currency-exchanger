package interactor

import data.ExchangeRate
import datasource.CurrencyService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import response.toExchangeRate

class ExchangeRatesInteractor(
    private val currencyService: CurrencyService
) {

    fun execute(): Flow<ExchangeRate> = flow {

        try {
            val apiResponse = currencyService.getExchangeRates()

            emit(apiResponse.toExchangeRate())

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
package datasource

import response.ExchangeRateDTO

interface CurrencyService {
    companion object{
        const val BASE_URL = "https://developers.paysera.com/tasks/api/"
        const val GET_RATES = "currency-exchange-rates"
    }

    suspend fun getExchangeRates(): ExchangeRateDTO

}
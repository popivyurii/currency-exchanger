package datasource

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.encodedPath
import io.ktor.http.takeFrom
import response.ExchangeRateDTO

class CurrencyServiceImpl(
    private val httpClient: HttpClient
): CurrencyService {

    override suspend fun getExchangeRates(): ExchangeRateDTO {
        return httpClient.get {
            url {
                takeFrom(CurrencyService.BASE_URL)
                encodedPath += CurrencyService.GET_RATES
            }

            contentType(ContentType.Application.Json)
        }.body()
    }
}
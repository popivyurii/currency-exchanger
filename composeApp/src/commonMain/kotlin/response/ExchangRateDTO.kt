package response

import data.ExchangeRate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/*
    {
    "base":"EUR",
    "date":"2022-10-06",
    "rates":{
    "AED":4.147043,
    "AFN":118.466773
}
 */
@Serializable
data class ExchangeRateDTO(
    @SerialName("base")
    val base: String?,
    @SerialName("date")
    val date: String?,
    @SerialName("rates")
    val rates: Map<String, Double>?
)

fun ExchangeRateDTO.toExchangeRate() = ExchangeRate(
    base = base ?: "",
    date = date ?: "",
    rates = rates ?: emptyMap(),
)

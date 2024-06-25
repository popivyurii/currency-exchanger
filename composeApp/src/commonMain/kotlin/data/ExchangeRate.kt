package data

data class ExchangeRate(
    val base: String = "",
    val date: String = "",
    val rates: Map<String, Double> = emptyMap()
)
package viewModel

sealed class ExchangeEvent {

    data object GetExchangeRates: ExchangeEvent()
}
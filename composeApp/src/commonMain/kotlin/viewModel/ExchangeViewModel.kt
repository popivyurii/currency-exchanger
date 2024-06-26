package viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import interactor.ExchangeRatesInteractor
import kotlinx.coroutines.flow.onEach

class ExchangeViewModel(
    private val interactor: ExchangeRatesInteractor
): ViewModel() {

    val state: MutableState<ExchangeState> = mutableStateOf(ExchangeState())

    fun onTriggerEvent(event: ExchangeEvent) {
        when (event) {
            is ExchangeEvent.GetExchangeRates -> {
                getExchangeRates()
            }
        }
    }

    private fun getExchangeRates() {
        interactor.execute().onEach {
            state.value = state.value.copy(exchangeRate = it)
        }

    }
}
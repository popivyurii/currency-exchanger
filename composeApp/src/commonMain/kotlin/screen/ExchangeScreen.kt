package screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import currency_exchanger.composeapp.generated.resources.Res
import currency_exchanger.composeapp.generated.resources.arrow_down
import currency_exchanger.composeapp.generated.resources.buy_currency
import currency_exchanger.composeapp.generated.resources.compose_multiplatform
import currency_exchanger.composeapp.generated.resources.sell_currency
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import viewModel.ExchangeEvent
import viewModel.ExchangeState
import viewModel.ExchangeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExchangeScreen (
//    viewModel: ExchangeViewModel,
//    state: ExchangeState,
//    onTriggerEvent: (ExchangeEvent) -> Unit
){

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Currency converter") }
            )
        }
    ) {
        Box(
            modifier = Modifier.padding(top = it.calculateTopPadding())
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.TopStart
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {

                Text(
                    text = "MY BALANCES",
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.Left
                )

                Spacer(modifier = Modifier.size(32.dp))

                BalanceRow(balances = listOf(
                    "1000.00 EUR",
                    "0.00 USD",
                    "0.00 BGN",
                    "1234.56 GBP",
                    "789.00 JPY"
                ))

                Spacer(modifier = Modifier.size(32.dp))

                Text(
                    text = "CURRENCY EXCHANGE",
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.Left
                )

                Spacer(modifier = Modifier.size(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.sell_currency),
                        null,
                        modifier = Modifier.size(35.dp).padding(4.dp))

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(text = "Sell", fontSize = 18.sp)

                    Spacer(modifier = Modifier.weight(1f))

                    Text(text = "100.00", fontSize = 18.sp)

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(text = "EUR", fontSize = 18.sp)

                    Spacer(modifier = Modifier.width(4.dp))

                    Icon(
                        painter = painterResource(Res.drawable.arrow_down),
                        null,
                        modifier = Modifier.size(35.dp))
                }

                HorizontalDivider()

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.buy_currency),
                        null,
                        modifier = Modifier.size(35.dp).padding(4.dp))

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(text = "Receive", fontSize = 18.sp)

                    Spacer(modifier = Modifier.weight(1f))

                    Text(text = "+110.00", fontSize = 18.sp, color = Color.Green)

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(text = "USD", fontSize = 18.sp)

                    Spacer(modifier = Modifier.width(4.dp))

                    Icon(
                        painter = painterResource(Res.drawable.arrow_down),
                        null,
                        modifier = Modifier.size(35.dp))
                }

                Spacer(modifier = Modifier.size(48.dp))

                GradientButton(
                    text = "SUBMIT",
                    ) {
                }


            }
        }
    }

}

@Composable
fun GradientButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        contentPadding = PaddingValues(),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(
                Brush.horizontalGradient(
                    colors = listOf(Color(0xFF4A90E2), Color(0xFF357ABD))
                )
            )
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun BalanceRow(balances: List<String>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(balances) { balance ->
            Text(
                text = balance,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

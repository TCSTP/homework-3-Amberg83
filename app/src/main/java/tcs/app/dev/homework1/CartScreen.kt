package tcs.app.dev.homework1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import tcs.app.dev.R
import tcs.app.dev.homework1.data.Cart
import tcs.app.dev.homework1.data.MockData
import tcs.app.dev.homework1.data.MockData.ExampleShop
import tcs.app.dev.homework1.data.Shop
import tcs.app.dev.homework1.data.plus
import tcs.app.dev.ui.theme.AppTheme
import kotlin.collections.iterator

@Composable
fun CartScreen (title: String, cart: Cart, modifier: Modifier = Modifier) {

    var state by rememberSaveable { mutableIntStateOf(0) }


    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Row(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.secondary)
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    title,
                    modifier = Modifier.padding(horizontal = 4.dp),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSecondary
                )

            }

        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondary)
                    .padding(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.total_price, cart.price),
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .weight(1f),
                    color = MaterialTheme.colorScheme.onSecondary,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                )
                TextButton(
                    onClick = { state = 1 },
                    modifier = Modifier
                        .weight(1f),
                    colors = buttonColors(
                        containerColor = MaterialTheme.colorScheme.onSecondary,
                        contentColor = MaterialTheme.colorScheme.secondary,
                        disabledContainerColor =
                            MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.5f),
                        disabledContentColor =
                            MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f)
                    ),
                ) {
                    Text(stringResource(R.string.label_pay),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.secondary)
                }
            }
        }
    ) { paddingValues ->
        if (cart.items.isEmpty())  {

            Text(stringResource(R.string.university_selection),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.secondary)
        }  else {
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.secondaryContainer),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    for (content in cart.items) {
                        item {
                            CartRow(
                                item = content.key,
                                price = cart.shop.prices.getValue(content.key),
                                amount = content.value
                            )
                        }
                    }
                }
            )
        }

    }
}


@Preview
@Composable
fun CartPreview() {
    var cart = Cart(shop = ExampleShop)
    cart.plus(Pair(MockData.Apple, 5U))
    cart.plus(Pair(MockData.Banana, 4U))
    AppTheme {
        CartScreen(
            title = stringResource(R.string.title_cart),
            cart = cart
        )
    }
}
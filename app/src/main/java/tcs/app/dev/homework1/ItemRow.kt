package tcs.app.dev.homework1

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tcs.app.dev.homework1.data.Euro
import tcs.app.dev.homework1.data.Item
import tcs.app.dev.homework1.data.MockData
import tcs.app.dev.ui.theme.AppTheme
import tcs.app.dev.R
import tcs.app.dev.homework1.data.Cart
import tcs.app.dev.homework1.data.Shop
import tcs.app.dev.homework1.data.plus


@Composable
fun ItemRow(
    item: Item,
    price: Euro,
    shop: Shop,
    modifier: Modifier = Modifier,
) {
    ItemRow(
        image = { modifier -> Image(painterResource(MockData.getImage(item)), contentDescription = null, modifier = modifier) },
        title = { modifier -> Text(item.id, modifier = modifier) },
        price =  { modifier -> Text(price.toString(), modifier = modifier) },
        item = item,
        shop = shop,
        modifier = modifier
    )
}


@Composable
fun ItemRow(
    image: @Composable (Modifier) -> Unit,
    title: @Composable (Modifier) -> Unit,
    price: @Composable (Modifier) -> Unit,
    item: Item,
    shop: Shop,
    modifier: Modifier = Modifier,
    onSelected: () -> Unit = {}
) {
    val border = BorderStroke(
        width = 1.dp,
        color = MaterialTheme.colorScheme.primary
    )

    val color = MaterialTheme.colorScheme.primaryContainer

    var cart by rememberSaveable { mutableStateOf(Cart(shop = shop)) }

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = MaterialTheme.shapes.medium,
        border = border,
        color = color
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            image(
                Modifier
                    .size(64.dp)
                    .clip(MaterialTheme.shapes.medium)
            )

            title(
                Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            )

            price(
                Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            )

            IconButton(
                modifier = Modifier.padding(end = 8.dp),
                content = {
                    Icon(
                        painterResource(R.drawable.cartbutton),
                        contentDescription = null,
                        modifier = Modifier.padding(all = 5.dp),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                },
                onClick = { cart.plus(item) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RadioRowSelectedPreview() {
    val shop = MockData.ExampleShop
    AppTheme {
        ItemRow(MockData.Banana, shop.prices.getValue(MockData.Banana), shop)
    }
}

//@Preview(showBackground = true)
//@Composable
//fun RadioRowNotSelectedPreview() {
//    AppTheme {
//        RadioRow(option = LMU, selected = false)
//    }
//}


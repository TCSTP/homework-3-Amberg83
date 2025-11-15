package tcs.app.dev.homework1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tcs.app.dev.R
import tcs.app.dev.exercise.university.data.Option
import tcs.app.dev.exercise.university.solution.RadioRow
import tcs.app.dev.homework1.data.Euro
import tcs.app.dev.homework1.data.Item
import tcs.app.dev.homework1.data.MockData.ExampleShop
import tcs.app.dev.homework1.data.Shop

import tcs.app.dev.ui.theme.AppTheme

@Composable
fun ShopItemTab (title: String, shop: Shop, modifier: Modifier = Modifier) {

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
                IconButton(
                    onClick = { },
                    content = {
                        Icon(
                            painterResource(R.drawable.cartbutton),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(end = 4.dp),
                            tint = MaterialTheme.colorScheme.onTertiary
                        )
                    },
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(32.dp)
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
                TextButton(
                    onClick = { },
                    modifier = Modifier.weight(1f),
                    colors = buttonColors(
                        containerColor = MaterialTheme.colorScheme.onSecondary,
                        contentColor = MaterialTheme.colorScheme.secondary,
                        disabledContainerColor =
                            MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.5f),
                        disabledContentColor =
                            MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f)
                    )
                ) {
                    Text(stringResource(R.string.label_shop),
                        style = MaterialTheme.typography.titleLarge)
                }
                TextButton(
                    onClick = { },
                    modifier = Modifier
                        .weight(1f),
                    colors = buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                        disabledContainerColor =
                            MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.5f),
                        disabledContentColor =
                            MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f)
                    ),
                ) {
                    Text(stringResource(R.string.label_discounts),
                        style = MaterialTheme.typography.titleLarge,)
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.secondaryContainer),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            content = {
                for (content in shop.prices) {
                    item {
                        ItemRow(
                        item = content.key,
                        price = content.value)
                    }
                }
            }
        )
    }
}


@Preview
@Composable
fun ShopItemsPreview() {
    AppTheme {
        ShopItemTab(
            title = stringResource(R.string.name_shop),
            shop = ExampleShop
        )
    }
}


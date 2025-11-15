package tcs.app.dev.homework1

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import tcs.app.dev.R
import tcs.app.dev.homework1.data.Discount
import tcs.app.dev.homework1.data.MockData

@Composable
fun BundleRow(
    item: Discount.Bundle,
    modifier: Modifier = Modifier,
    onSelected: () -> Unit = {}
) {
    val border = BorderStroke(
        width = 1.dp,
        color = MaterialTheme.colorScheme.primary
    )

    val color = MaterialTheme.colorScheme.primaryContainer

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
            Image(
                painter = painterResource(MockData.getImage(item.item)),
                modifier = Modifier
                    .size(64.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentDescription = null
            )

            Text(
                text = stringResource(
                    R.string.pay_n_items_and_get,
                    item.amountItemsPay,
                    item.item.id,
                    item.amountItemsGet
                ),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            )


        }
    }
}

@Composable
fun FixedRow(
    item: Discount.Fixed,
    modifier: Modifier = Modifier,
    onSelected: () -> Unit = {}
) {
    val border = BorderStroke(
        width = 1.dp,
        color = MaterialTheme.colorScheme.primary
    )

    val color = MaterialTheme.colorScheme.primaryContainer

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
            Image(
                painter = painterResource(R.drawable.eurosym),
                modifier = Modifier
                    .size(64.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentDescription = null
            )

            Text(
                text = stringResource(R.string.amount_off, item.amount),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            )


        }
    }
}

@Composable
fun PercentageRow(
    item: Discount.Percentage,
    modifier: Modifier = Modifier,
    onSelected: () -> Unit = {}
) {
    val border = BorderStroke(
        width = 1.dp,
        color = MaterialTheme.colorScheme.primary
    )

    val color = MaterialTheme.colorScheme.primaryContainer

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
            Image(
                painter = painterResource(R.drawable.percentsym),
                modifier = Modifier
                    .size(64.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentDescription = null
            )

            Text(
                text = stringResource(R.string.percentage_off, item.value),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            )


        }
    }
}
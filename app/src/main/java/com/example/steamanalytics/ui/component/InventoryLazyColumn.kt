package com.example.steamanalytics.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.domain.entities.InventoryItem
import com.example.domain.utils.Result
import com.example.steamanalytics.R
import com.example.steamanalytics.ui.theme.AppTheme
import com.example.steamanalytics.viewmodels.InventoryViewModel
import com.example.steamanalytics.viewmodels.ItemViewModel

@Composable
fun InventoryLazyColumn(
    navController: NavController,
    viewModel: InventoryViewModel
) {
    val itemViewModel : ItemViewModel = hiltViewModel()

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.horizontal_padding)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.horizontal_padding)),
        content = {
            items(
                items = viewModel.inventoryItemList,
                key = { inventoryItem: InventoryItem ->
                    inventoryItem.id
                }
            ) {
                Card(
                    modifier = Modifier
                        .size(LocalConfiguration.current.screenHeightDp.dp / 6)
                        .border(
                            border = BorderStroke(
                                1.dp,
                                Color(
                                    android.graphics.Color.parseColor(
                                        it.nameColor.padStart(
                                            7,
                                            '#'
                                        )
                                    )
                                )
                            ),
                            shape = RoundedCornerShape(10.dp)
                        ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        NetworkImage(it.iconUrl)
                        if (it.tags[1].category == "Weapon" || it.tags[0].localizedTagName == "Gloves") {
                            Text(
                                text = it.descriptions[0].value.substring(10)
                                    .filter { it.isUpperCase() },
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Center
                            )
                        } else if (it.tags[0].localizedTagName == "Container") {
                            Text(
                                text = it.name,
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Center
                            )
                        } else {
                            Text(
                                text = it.name.split("|").getOrElse(1) { "" },
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Center
                            )
                        }
                        if(it.marketable == 1) {
                            ItemPriceText(it.marketName, itemViewModel)
                        }
                    }
                }
            }
        }
    )
}


@Preview
@Composable
private fun AccessoryLazyColumnPreview() {
    AppTheme {
        val navController: NavController = rememberNavController()
        InventoryLazyColumn(navController, hiltViewModel())
    }
}
package com.example.steamanalytics.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.steamanalytics.ui.theme.AppTheme
import com.example.steamanalytics.viewmodels.InventoryViewModel
import com.example.steamanalytics.R

@Composable
fun InventoryLazyColumn(
    navController: NavController,
    viewModel: InventoryViewModel
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.horizontal_padding)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.horizontal_padding)),
        content = {
            items(viewModel.itemList.size) { index ->
                Item(viewModel.itemList[index])
            }
        })
}


@Preview
@Composable
private fun AccessoryLazyColumnPreview() {
    AppTheme {
        val navController: NavController = rememberNavController()
        InventoryLazyColumn(navController, hiltViewModel())
    }
}
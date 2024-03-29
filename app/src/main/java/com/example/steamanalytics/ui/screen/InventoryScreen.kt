package com.example.steamanalytics.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.domain.utils.Result
import com.example.steamanalytics.R
import com.example.steamanalytics.ui.component.HeadersTextView
import com.example.steamanalytics.ui.component.InventoryLazyColumn
import com.example.steamanalytics.ui.theme.AppTheme
import com.example.steamanalytics.viewmodels.AppViewModel
import com.example.steamanalytics.viewmodels.InventoryViewModel
import com.example.steamanalytics.viewmodels.ItemViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun InventoryScreen(
    navController: NavController,
    viewModel: InventoryViewModel
) {

    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(0.15f)
                .padding(start = 30.dp, bottom = 10.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            HeadersTextView(text = stringResource(id = R.string.inventory))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(0.85f)
                .padding(horizontal = dimensionResource(id = R.dimen.vertical_padding)),
            contentAlignment = Alignment.Center
        ) {
            InventoryLazyColumn(navController, viewModel)
        }
    }

}

@Composable
@Preview
fun InventoryScreenPreview() {
    AppTheme {
        val navController: NavController = rememberNavController()
        InventoryScreen(navController, hiltViewModel())
    }
}
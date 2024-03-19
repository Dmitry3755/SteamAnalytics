package com.example.steamanalytics.ui.component

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.domain.utils.Result
import com.example.steamanalytics.viewmodels.AppViewModel
import com.example.steamanalytics.viewmodels.InventoryViewModel
import com.example.steamanalytics.viewmodels.ItemViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun ItemPriceText(
    marketName: String,
    itemViewModel: ItemViewModel,
    appViewModel: AppViewModel,
    id: Int
) {

    var price by remember { mutableStateOf("") }

    LaunchedEffect(marketName) {
        if (appViewModel.internetState.value) {
            val context = withContext(Dispatchers.IO) {
                itemViewModel.getPriceOfItem(marketName)
            }
            if (context is Result.Success) {
                price = context.data.lowestPrice ?: ""
                itemViewModel.itemPriceList.add(context.data)
                itemViewModel.insertPriceOfItem(itemViewModel.itemPriceList.lastIndex)
            } else {
                price = itemViewModel.getPriceOfItemDb(id) ?: ""
            }
        } else {
            price = itemViewModel.getPriceOfItemDb(id)  ?: ""
        }
    }

    Text(
        text = price,
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center
    )
}

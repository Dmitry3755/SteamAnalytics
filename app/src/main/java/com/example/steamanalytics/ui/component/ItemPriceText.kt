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
import com.example.domain.utils.Result
import com.example.steamanalytics.viewmodels.InventoryViewModel
import com.example.steamanalytics.viewmodels.ItemViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun ItemPriceText(marketName: String, viewModel: ItemViewModel) {

    var price by remember { mutableStateOf("") }

    LaunchedEffect(marketName) {
        val context = withContext(Dispatchers.IO) {
            viewModel.getPriceOfItem(marketName)
        }
        if (context is Result.Success) {
            price = context.data.lowestPrice!!
        }
    }
    Text(
        text = price,
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center
    )
}

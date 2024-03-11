package com.example.steamanalytics.ui.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.domain.utils.Result
import com.example.steamanalytics.ui.component.MainButton
import com.example.steamanalytics.R
import com.example.steamanalytics.ui.component.AppTextField
import com.example.steamanalytics.ui.component.HeadersTextView
import com.example.steamanalytics.utils.ViewError
import com.example.steamanalytics.viewmodels.InventoryViewModel
import kotlinx.coroutines.launch
import com.example.steamanalytics.ui.navigation.Navigation

@Composable
fun SteamIdScreen(navController: NavController, viewModel: InventoryViewModel, context: Context) {

    val coroutineScope = rememberCoroutineScope()
    val verifyResultViewError = remember { mutableStateOf(ViewError()) }

    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(MaterialTheme.colorScheme.tertiary)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(1f)
                .weight(0.2f),
            contentAlignment = Alignment.BottomStart
        ) {
            HeadersTextView(text = stringResource(R.string.edit_text_hint_enter_steam_id))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(0.8f)
                .background(
                    MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(1f)
                    .fillMaxWidth(1f)
                    .padding(
                        top = dimensionResource(id = R.dimen.text_view_padding),
                        start = dimensionResource(id = R.dimen.text_view_padding),
                        end = dimensionResource(id = R.dimen.text_view_padding)
                    ),
                contentAlignment = Alignment.Center
            ) {
                AppTextField(
                    hintTextField = stringResource(id = R.string.edit_text_hint_enter_steam_id),
                    value = viewModel.steamId,
                    viewError = verifyResultViewError,
                    enterSteamId = true
                )
                MainButton(
                    textButton =
                    stringResource(id = R.string.button_text_continue),
                    onClick = {
                        coroutineScope.launch {
                            val result = viewModel.getInventory(verifyResultViewError)
                            if (result is Result.Success) {
                                viewModel.itemList = result.data.descriptions.toMutableList()
                                navController.navigate(Navigation.InventoryScreen.route)
                            } else {
                                Toast.makeText(
                                    context,
                                    (result as Result.Error).exception.message,
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    }
                )
            }
        }
    }
}
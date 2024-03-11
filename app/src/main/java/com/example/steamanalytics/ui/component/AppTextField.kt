package com.example.steamanalytics.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.steamanalytics.R
import com.example.steamanalytics.utils.ViewError
import com.example.steamanalytics.ui.theme.AppTheme
import com.example.steamanalytics.ui.theme.shapes

@Composable
fun AppTextField(
    hintTextField: String,
    value: MutableState<String>,
    viewError: MutableState<ViewError> = mutableStateOf(ViewError()),
    enterSteamId : Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(1f)
    ) {
        TextField(
            value = value.value,
            modifier = Modifier
                .fillMaxWidth(1f),
            placeholder = {
                Text(
                    text = hintTextField,
                    style = MaterialTheme.typography.bodyMedium
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            isError = viewError.value.isError.value,
            onValueChange = { newText ->
                run {
                    value.value = newText
                    viewError.value.isError.value = false
                }
            },
            shape = shapes.extraSmall
        )
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    AppTheme {
        AppTextField(
            hintTextField = stringResource(id = R.string.edit_text_hint_enter_steam_id),
            value  = remember { mutableStateOf("")},
            enterSteamId = true
        )
    }
}
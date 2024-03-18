package com.example.steamanalytics.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.steamanalytics.R
import com.example.steamanalytics.ui.theme.AppTheme
import com.example.steamanalytics.ui.theme.shapes
import com.example.steamanalytics.utils.ViewError

@Composable
fun AppTextField(
    hintTextField: String,
    value: MutableState<String>,
    viewError: MutableState<ViewError> = mutableStateOf(ViewError())
) {

    OutlinedTextField(
        value = value.value,
        modifier = Modifier.fillMaxWidth(1f),
        textStyle = MaterialTheme.typography.bodyMedium,
        placeholder = {
            Text(
                text = hintTextField,
                color = MaterialTheme.colorScheme.outline,
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
        shape = shapes.medium,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = MaterialTheme.colorScheme.outline,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.outline,
            backgroundColor = MaterialTheme.colorScheme.background
        )
    )
}


@Preview
@Composable
private fun DefaultPreview() {
    AppTheme {
        AppTextField(
            hintTextField = stringResource(id = R.string.edit_text_hint_enter_steam_id),
            value = remember { mutableStateOf("") }
        )
    }
}
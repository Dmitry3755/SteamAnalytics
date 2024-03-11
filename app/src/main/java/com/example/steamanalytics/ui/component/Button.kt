package com.example.steamanalytics.ui.component

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.steamanalytics.ui.theme.AppTheme
import com.example.steamanalytics.R
import com.example.steamanalytics.ui.theme.shapes

@Composable
fun MainButton(
    textButton: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        shape = shapes.small
    ) {
        Text(
            text = textButton,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun ButtonPreview() {
    AppTheme {
        MainButton(textButton = stringResource(id = R.string.button_text_continue),
            onClick = {})
    }
}
package com.example.steamanalytics.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.steamanalytics.R
import com.example.steamanalytics.ui.theme.AppTheme
import com.example.steamanalytics.ui.theme.shapes

@Composable
fun MainButton(
    textButton: String,
    onClick: () -> Unit,
) {
    Button(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(bottom = dimensionResource(id = R.dimen.vertical_padding))
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        onClick = onClick,
        shape = shapes.small
    ) {
        Text(
            text = textButton,
            style = MaterialTheme.typography.bodyLarge
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
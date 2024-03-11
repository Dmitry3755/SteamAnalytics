package com.example.steamanalytics.ui.component

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import com.example.steamanalytics.ui.theme.AppTheme
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@Composable
fun ImagePicasso(url: String) {

    var image by remember { mutableStateOf<Bitmap?>(null) }

    LaunchedEffect(url) {
        val bitmap = withContext(Dispatchers.IO) {
            Picasso.get().load("https://community.akamai.steamstatic.com/economy/image/$url").get()
        }
        image = bitmap
    }
    image?.let {
        Image(bitmap = it.asImageBitmap(), contentDescription = null)
    }

}

@Preview
@Composable
fun NetworkImagePreview() {
    AppTheme {
        ImagePicasso("")
    }
}
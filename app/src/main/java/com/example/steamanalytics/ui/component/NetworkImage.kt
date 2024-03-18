package com.example.steamanalytics.ui.component

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.steamanalytics.R
import com.example.steamanalytics.ui.theme.AppTheme
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@Composable
fun NetworkImage(url: String) {
    var image by remember { mutableStateOf<Bitmap?>(null) }

    LaunchedEffect(url) {
        val bitmap = withContext(Dispatchers.IO) {
            Picasso.get().load("https://community.akamai.steamstatic.com/economy/image/$url")
                .placeholder(R.drawable.ic_steam).get()
        }
        image = bitmap
    }
    image?.let {
        Image(
            bitmap = it.asImageBitmap(),
            alignment = Alignment.TopCenter,
            contentDescription = null,
            contentScale = ContentScale.Inside,
            filterQuality = FilterQuality.Low
        )
    }
}

@Preview
@Composable
fun NetworkImagePreview() {
    AppTheme {
        NetworkImage("")
    }
}
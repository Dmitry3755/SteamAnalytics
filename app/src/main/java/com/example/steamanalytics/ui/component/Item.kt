package com.example.steamanalytics.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.domain.entities.Item

@Composable
fun Item(item: Item) {

    Card(
        modifier = Modifier
            .border(
                BorderStroke(0.dp, Color.Transparent),
                shape = MaterialTheme.shapes.small
            )
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            ImagePicasso(item.iconUrl)
        }
    }

}
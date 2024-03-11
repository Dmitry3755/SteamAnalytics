package com.example.data.mappers

import com.example.data.entities.DescriptionItemApiResponse
import com.example.domain.entities.DescriptionItem

fun DescriptionItemApiResponse.toItemDescription(): DescriptionItem {
    return DescriptionItem(
        value = this.value,
        color = this.color
    )
}
package com.example.data.mappers

import com.example.data.entities.TagItemApiResponse
import com.example.domain.entities.DescriptionItem
import com.example.domain.entities.TagItem

fun TagItemApiResponse.toItemTag(): TagItem {
    return TagItem(
        category = this.category,
        internalName = this.internalName,
        localizedCategoryName = this.localizedCategoryName,
        localizedTagName = this.localizedTagName
    )
}

fun TagItem.toTagItemApiResponse(): TagItemApiResponse {
    return TagItemApiResponse(
        category = this.category,
        internalName = this.internalName,
        localizedCategoryName = this.localizedCategoryName,
        localizedTagName = this.localizedTagName
    )
}
package com.example.data.entities

import com.google.gson.annotations.SerializedName

data class TagItemApiResponse(
    @SerializedName("category")
    val category: String,
    @SerializedName("internal_name")
    val internalName: String,
    @SerializedName("localized_category_name")
    val localizedCategoryName: String,
    @SerializedName("localized_tag_name")
    val localizedTagName: String
)
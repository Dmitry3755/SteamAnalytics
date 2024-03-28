package com.example.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class TagItemApiResponse(
    @SerializedName("category")
    var category: String,
    @SerializedName("internal_name")
    var internalName: String,
    @SerializedName("localized_category_name")
    var localizedCategoryName: String,
    @SerializedName("localized_tag_name")
    var localizedTagName: String,
    @SerializedName("color")
    var color : String?
)
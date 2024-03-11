package com.example.data.entities

import com.google.gson.annotations.SerializedName

data class DescriptionItemApiResponse(
    @SerializedName("value")
    val value : String,
    @SerializedName("color")
    var color : String?
)

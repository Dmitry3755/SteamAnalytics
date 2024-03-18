package com.example.data.entities

import com.google.gson.annotations.SerializedName

data class ItemMarketApiResponse(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("lowest_price")
    val lowestPrice: String?,
    @SerializedName("volume")
    val volume: String?,
    @SerializedName("median_price")
    val medianPrice: String?
)

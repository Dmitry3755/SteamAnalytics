package com.example.data.entities

import com.google.gson.annotations.SerializedName

data class ItemApiResponse(
    @SerializedName("icon_url")
    val iconUrl: String,
    @SerializedName("descriptions")
    val descriptions: List<DescriptionItemApiResponse>,
    @SerializedName("tradable")
    val tradable: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("name_color")
    val nameColor: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("market_name")
    val marketName: String,
    @SerializedName("market_hash_name")
    val marketHashName: String,
    @SerializedName("market_tradable_restriction")
    val marketTradableRestriction: Int,
    @SerializedName("marketable")
    val marketable: Int,
    @SerializedName("tags")
    val tags: List<TagItemApiResponse>,
)

package com.example.domain.entities

data class Item(
    val iconUrl: String,
    val descriptions: List<DescriptionItem>,
    val tradable: Int,
    val name: String,
    val nameColor: String,
    val type: String,
    val marketName: String,
    val marketHashName: String,
    val marketTradableRestriction: Int,
    val marketable: Int,
) {}
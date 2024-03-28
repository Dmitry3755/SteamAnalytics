package com.example.domain.entities

data class ItemMarket(
    val id : Int,
    val success: Boolean,
    val lowestPrice: String?,
    val volume: String?,
    val medianPrice: String?,
    val itemId : Int
)

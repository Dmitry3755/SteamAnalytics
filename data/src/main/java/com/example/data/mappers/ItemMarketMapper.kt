package com.example.data.mappers

import com.example.data.entities.ItemMarketApiResponse
import com.example.domain.entities.ItemMarket

fun ItemMarketApiResponse.toItemMarket(): ItemMarket {
    return ItemMarket(
        id = this.id,
        success = this.success,
        lowestPrice = this.lowestPrice,
        volume = this.volume,
        medianPrice = this.medianPrice,
        itemId = this.itemId
    )
}

fun ItemMarket.toItemMarketApiResponse(): ItemMarketApiResponse {
    return ItemMarketApiResponse(
        id = this.id,
        success = this.success,
        lowestPrice = this.lowestPrice,
        volume = this.volume,
        medianPrice = this.medianPrice,
        itemId = this.itemId
    )
}
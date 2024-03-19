package com.example.data.mappers

import com.example.data.entities.ItemMarketApiResponse
import com.example.domain.entities.ItemMarket

fun ItemMarketApiResponse.toItemMarket(): ItemMarket {
    return ItemMarket(
        success = this.success,
        lowestPrice = this.lowestPrice,
        volume = this.volume,
        medianPrice = this.medianPrice
    )
}

fun ItemMarket.toItemMarketApiResponse(): ItemMarketApiResponse {
    return ItemMarketApiResponse(
        success = this.success,
        lowestPrice = this.lowestPrice,
        volume = this.volume,
        medianPrice = this.medianPrice
    )
}
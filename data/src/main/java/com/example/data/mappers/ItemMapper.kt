package com.example.data.mappers

import com.example.data.entities.ItemApiResponse
import com.example.domain.entities.Item

fun ItemApiResponse.toItem(): Item {
    return Item(
        iconUrl = this.iconUrl,
        descriptions = this.descriptions.map { it.toItemDescription() },
        tradable = this.tradable,
        name = this.name,
        nameColor = this.nameColor,
        type = this.type,
        marketName = this.marketName,
        marketHashName = this.marketHashName,
        marketTradableRestriction = this.marketTradableRestriction,
        marketable = this.marketable
    )
}
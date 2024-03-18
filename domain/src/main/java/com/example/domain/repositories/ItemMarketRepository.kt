package com.example.domain.repositories

import com.example.domain.entities.ItemMarket
import com.example.domain.utils.Result

interface ItemMarketRepository  {
    suspend fun getPriceMarketAboutItem(marketName: String) : Result<ItemMarket>
}
package com.example.domain.repositories

import com.example.domain.entities.InventoryItem
import com.example.domain.entities.ItemMarket

interface ItemMarketRepositoryDb {

    suspend fun getPriceOfAllItems(): List<ItemMarket>

    suspend fun insertPriceOfItem(itemMarket: ItemMarket)

    suspend fun updateCurrentPriceOfItem(item: ItemMarket)

}
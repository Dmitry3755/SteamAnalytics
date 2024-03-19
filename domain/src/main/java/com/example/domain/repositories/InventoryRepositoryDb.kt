package com.example.domain.repositories

import com.example.domain.entities.InventoryItem
import com.example.domain.entities.ItemMarket

interface InventoryRepositoryDb {

    suspend fun getAllItems() : List<InventoryItem>

    suspend fun getPriceOfItem(itemId : Int) : String?

    suspend fun insertItem(itemsList: List<InventoryItem>)

    suspend fun insertPriceOfItem(price : ItemMarket)

    suspend fun update(itemList: List<InventoryItem>)

}
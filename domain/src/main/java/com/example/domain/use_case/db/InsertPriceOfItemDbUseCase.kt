package com.example.domain.use_case.db

import com.example.domain.entities.InventoryItem
import com.example.domain.entities.ItemMarket
import com.example.domain.repositories.InventoryRepositoryDb
import javax.inject.Inject

class InsertPriceOfItemDbUseCase @Inject constructor(private val inventoryRepositoryDb: InventoryRepositoryDb) {
    suspend fun invoke(itemsMarket: ItemMarket) = inventoryRepositoryDb.insertPriceOfItem(itemsMarket)
}
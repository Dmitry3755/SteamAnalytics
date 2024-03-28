package com.example.domain.use_case.db

import com.example.domain.entities.InventoryItem
import com.example.domain.entities.ItemMarket
import com.example.domain.repositories.InventoryRepositoryDb
import com.example.domain.repositories.ItemMarketRepositoryDb
import javax.inject.Inject

class InsertPriceOfItemDbUseCase @Inject constructor(private val itemMarketRepositoryDb: ItemMarketRepositoryDb) {
    suspend fun invoke(itemsMarket: ItemMarket) = itemMarketRepositoryDb.insertPriceOfItem(itemsMarket)
}
package com.example.domain.use_case.db

import com.example.domain.entities.ItemMarket
import com.example.domain.repositories.InventoryRepositoryDb
import javax.inject.Inject

class GetPriceOfItemDbUseCase @Inject constructor(private val inventoryRepositoryDb: InventoryRepositoryDb) {
    suspend fun invoke(itemId: Int) = inventoryRepositoryDb.getPriceOfItem(itemId)
}
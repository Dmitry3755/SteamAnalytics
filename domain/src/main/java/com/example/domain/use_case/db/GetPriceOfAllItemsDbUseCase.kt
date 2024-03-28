package com.example.domain.use_case.db

import com.example.domain.repositories.InventoryRepositoryDb
import com.example.domain.repositories.ItemMarketRepositoryDb
import javax.inject.Inject

class GetPriceOfAllItemsDbUseCase @Inject constructor(private val itemMarketRepositoryDb: ItemMarketRepositoryDb) {
    suspend fun invoke() = itemMarketRepositoryDb.getPriceOfAllItems()
}
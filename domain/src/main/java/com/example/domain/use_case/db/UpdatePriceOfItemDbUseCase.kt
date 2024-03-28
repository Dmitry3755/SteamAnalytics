package com.example.domain.use_case.db

import com.example.domain.entities.ItemMarket
import com.example.domain.repositories.ItemMarketRepositoryDb
import javax.inject.Inject

class UpdatePriceOfItemDbUseCase @Inject constructor(private val itemMarketRepositoryDb: ItemMarketRepositoryDb) {
    suspend fun invoke(item : ItemMarket) = itemMarketRepositoryDb.updateCurrentPriceOfItem(item)
}
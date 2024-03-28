package com.example.data.repositories.db

import com.example.data.dao.ItemMarketDao
import com.example.data.mappers.toItemMarket
import com.example.data.mappers.toItemMarketApiResponse
import com.example.domain.entities.InventoryItem
import com.example.domain.entities.ItemMarket
import com.example.domain.repositories.ItemMarketRepositoryDb
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class ItemMarketRepositoryDbImpl @Inject constructor(private val itemMarketDao: ItemMarketDao) :
    ItemMarketRepositoryDb {

    override suspend fun getPriceOfAllItems(): List<ItemMarket> {
        return itemMarketDao.getPriceOfAllItems().map { it.toItemMarket() }
    }

    override suspend fun insertPriceOfItem(itemMarket: ItemMarket) {
        itemMarketDao.insertPriceOfItem(itemMarket.toItemMarketApiResponse())
    }

    override suspend fun updateCurrentPriceOfItem(item: ItemMarket) {
        itemMarketDao.updateCurrentPriceOfItem(item.toItemMarketApiResponse())
    }
}
package com.example.data.repositories.db

import com.example.data.dao.InventoryDao
import com.example.data.entities.ItemApiResponse
import com.example.data.entities.ItemMarketApiResponse
import com.example.data.mappers.toItem
import com.example.data.mappers.toItemApiResponse
import com.example.data.mappers.toItemMarket
import com.example.data.mappers.toItemMarketApiResponse
import com.example.domain.entities.InventoryItem
import com.example.domain.entities.ItemMarket
import com.example.domain.repositories.InventoryRepositoryDb
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class InventoryRepositoryDbImpl @Inject constructor(private val inventoryDao: InventoryDao) :
    InventoryRepositoryDb {

    override suspend fun getAllItems(): List<InventoryItem> {
        return inventoryDao.getAllItems()
            .mapIndexed { index, itemApiResponse -> itemApiResponse.toItem(index + 1) }
    }

    override suspend fun insertItem(itemsList: List<InventoryItem>) {
        inventoryDao.insertItems(itemsList.map { it.toItemApiResponse() })
    }

    override suspend fun update(itemsList: List<InventoryItem>) {
        inventoryDao.update(itemsList.map { it.toItemApiResponse() })
    }
}
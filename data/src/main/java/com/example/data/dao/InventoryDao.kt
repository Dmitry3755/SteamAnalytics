package com.example.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.ItemApiResponse
import com.example.data.entities.ItemMarketApiResponse

@Dao
interface InventoryDao {

    @Query("SELECT * FROM inventory ORDER BY id ASC")
    suspend fun getAllItems(): List<ItemApiResponse>

    @Query("SELECT item_price.lowest_price FROM item_price JOIN inventory ON item_price.item_id = inventory.id WHERE inventory.id = :itemId")
    suspend fun getPriceOfItem(itemId: Int): String?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItems(itemsList: List<ItemApiResponse>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPriceOfItem(itemMarket: ItemMarketApiResponse)

    @Update
    suspend fun update(itemsList: List<ItemApiResponse>)
}
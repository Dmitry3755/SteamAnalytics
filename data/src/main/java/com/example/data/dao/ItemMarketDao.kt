package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.ItemApiResponse
import com.example.data.entities.ItemMarketApiResponse

@Dao
interface ItemMarketDao {

    /*@Query("SELECT * FROM item_price JOIN inventory ON item_price.item_id = inventory.id WHERE inventory.id = :itemId")
    suspend fun getPriceOfItem(itemId: Int): ItemMarketApiResponse*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPriceOfItem(itemMarket: ItemMarketApiResponse)

    @Query("SELECT * FROM item_price ORDER BY id ASC")
    suspend fun getPriceOfAllItems(): List<ItemMarketApiResponse>

    @Update
    suspend fun updateCurrentPriceOfItem(item: ItemMarketApiResponse)

    @Delete
    suspend fun deleteCurrentItem(item : ItemMarketApiResponse)

}
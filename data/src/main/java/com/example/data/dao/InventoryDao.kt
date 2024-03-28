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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItems(itemsList: List<ItemApiResponse>)

    @Update
    suspend fun update(itemsList: List<ItemApiResponse>)

}
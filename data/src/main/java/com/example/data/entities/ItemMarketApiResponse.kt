package com.example.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "item_price", foreignKeys = [
        ForeignKey(
            entity = ItemApiResponse::class, parentColumns =
            ["id"],
            childColumns = ["item_id"]
        )]
)
data class ItemMarketApiResponse(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 1,
    @SerializedName("success")
    var success: Boolean,
    @ColumnInfo(name = "lowest_price")
    @SerializedName("lowest_price")
    var lowestPrice: String?,
    @SerializedName("volume")
    var volume: String?,
    @ColumnInfo(name = "median_price")
    @SerializedName("median_price")
    var medianPrice: String?,
    @ColumnInfo(name = "item_id", index = true)
    var itemId: Int
)


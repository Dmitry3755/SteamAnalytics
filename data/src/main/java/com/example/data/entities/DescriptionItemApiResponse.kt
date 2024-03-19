package com.example.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class DescriptionItemApiResponse(
    @SerializedName("value")
    val value: String,
    @SerializedName("color")
    val color: String?
)
package com.example.data.converter

import androidx.room.TypeConverter
import com.example.data.entities.DescriptionItemApiResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DescriptionItemApiResponseConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromDescriptionItemApiResponseList(descriptionItemList: List<DescriptionItemApiResponse>): String {
        return gson.toJson(descriptionItemList)
    }

    @TypeConverter
    fun toDescriptionItemApiResponseList(json: String): List<DescriptionItemApiResponse> {
        val listType = object : TypeToken<List<DescriptionItemApiResponse>>() {}.type
        return gson.fromJson(json, listType)
    }
}
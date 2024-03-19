package com.example.data.converter

import androidx.room.TypeConverter
import com.example.data.entities.DescriptionItemApiResponse
import com.example.data.entities.TagItemApiResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TagItemApiResponseConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromTagItemApiResponseList(tagItemList: List<TagItemApiResponse>): String {
        return gson.toJson(tagItemList)
    }

    @TypeConverter
    fun toTagItemApiResponseList(json: String): List<TagItemApiResponse> {
        val listType = object : TypeToken<List<TagItemApiResponse>>() {}.type
        return gson.fromJson(json, listType)
    }
}
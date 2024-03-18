package com.example.data.api

import com.example.data.entities.ItemMarketApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.Currency

interface ItemMarketApi {
    @GET("/market/priceoverview/")
    suspend fun getPrice(@Query("currency") currency: Int,@Query("appid") appId : Int, @Query("market_hash_name") marketName: String): Response<ItemMarketApiResponse>
}
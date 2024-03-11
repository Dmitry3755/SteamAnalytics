package com.example.data.api

import com.example.data.entities.InventoryApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface InventoryApi {
    @GET("{steamId}/730/2")
    suspend fun get(@Path("steamId") steamId: String): Response<InventoryApiResponse>
}
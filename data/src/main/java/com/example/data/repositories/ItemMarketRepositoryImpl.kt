package com.example.data.repositories

import com.example.data.api.ItemMarketApi
import com.example.data.entities.ItemMarketApiResponse
import com.example.data.mappers.toItemMarket
import com.example.domain.entities.ItemMarket
import com.example.domain.repositories.ItemMarketRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.domain.utils.Result
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class ItemMarketRepositoryImpl @Inject constructor(private val itemMarketApi: ItemMarketApi) :
    ItemMarketRepository {
    override suspend fun getPriceMarketAboutItem(marketName: String): Result<ItemMarket> {
        return withContext(Dispatchers.IO) {
            lateinit var response: Response<ItemMarketApiResponse>
            try {
                response = itemMarketApi.getPrice(5, 730, marketName)
                if (response.isSuccessful) {
                    Result.Success(response.body()!!.toItemMarket())
                } else {
                    Result.Error(Exception(response.message()))
                }
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
    }
}
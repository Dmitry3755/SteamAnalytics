package com.example.steamanalytics.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.entities.InventoryItem
import com.example.domain.entities.ItemMarket
import com.example.domain.use_case.GetPriceOfItemUseCase
import com.example.domain.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(private val getPriceOfItemUseCase: GetPriceOfItemUseCase) :
    ViewModel() {

    lateinit var itemMarketList: MutableList<ItemMarket>

    suspend fun getPriceOfItem(marketName: String): Result<ItemMarket> {
        return getPriceOfItemUseCase.invoke(marketName)
    }

}
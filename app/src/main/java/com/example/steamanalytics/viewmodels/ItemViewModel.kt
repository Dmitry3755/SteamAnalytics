package com.example.steamanalytics.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.entities.InventoryItem
import com.example.domain.entities.ItemMarket
import com.example.domain.use_case.GetPriceOfItemUseCase
import com.example.domain.use_case.db.GetPriceOfItemDbUseCase
import com.example.domain.use_case.db.InsertPriceOfItemDbUseCase
import com.example.domain.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val getPriceOfItemUseCase: GetPriceOfItemUseCase,
    private val getPriceOfItemDbUseCase: GetPriceOfItemDbUseCase,
    private val insertPriceOfItemDbUseCase: InsertPriceOfItemDbUseCase
) :
    ViewModel() {

    lateinit var itemPriceList: MutableList<ItemMarket>

    suspend fun getPriceOfItem(marketName: String): Result<ItemMarket> {
        return getPriceOfItemUseCase.invoke(marketName)
    }

    suspend fun getPriceOfItemDb(itemId : Int): String? {
        return getPriceOfItemDbUseCase.invoke(itemId)
    }

    suspend fun insertPriceOfItem(itemId: Int) {
         insertPriceOfItemDbUseCase.invoke(itemPriceList[itemId])
    }
}
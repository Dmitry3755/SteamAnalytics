package com.example.steamanalytics.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.entities.ItemMarket
import com.example.domain.use_case.GetPriceOfItemUseCase
import com.example.domain.use_case.db.GetPriceOfAllItemsDbUseCase
import com.example.domain.use_case.db.InsertPriceOfItemDbUseCase
import com.example.domain.use_case.db.UpdatePriceOfItemDbUseCase
import com.example.domain.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val getPriceOfItemUseCase: GetPriceOfItemUseCase,
    private val getPriceOfAllItemsDbUseCase: GetPriceOfAllItemsDbUseCase,
    private val insertPriceOfItemDbUseCase: InsertPriceOfItemDbUseCase,
    private val updatePriceOfItemDbUseCase: UpdatePriceOfItemDbUseCase
) :
    ViewModel() {
    var itemPriceList: MutableList<ItemMarket> = mutableListOf()

    suspend fun getPriceOfItem(marketName: String): Result<ItemMarket> {
        return getPriceOfItemUseCase.invoke(marketName)
    }

    suspend fun getPriceAllOfItemsDb(): List<ItemMarket> {
        itemPriceList = getPriceOfAllItemsDbUseCase.invoke().toMutableList()
        return getPriceOfAllItemsDbUseCase.invoke()
    }

    suspend fun insertPriceOfItem(item: ItemMarket) {
        itemPriceList.add(item)
        insertPriceOfItemDbUseCase.invoke(item)
    }

    suspend fun updateCurrentPriceOfItem(index: Int, item: ItemMarket) {
        itemPriceList[index] = item
        updatePriceOfItemDbUseCase.invoke(item)
    }
}
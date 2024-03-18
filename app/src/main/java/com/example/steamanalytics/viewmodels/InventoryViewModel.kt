package com.example.steamanalytics.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.domain.entities.Inventory
import com.example.domain.entities.InventoryItem
import com.example.domain.entities.ItemMarket
import com.example.domain.use_case.GetInventoryUseCase
import com.example.domain.use_case.GetPriceOfItemUseCase
import com.example.domain.utils.Result
import com.example.steamanalytics.services.SteamIdValidation
import com.example.steamanalytics.utils.ViewError
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class InventoryViewModel @Inject constructor(
    private val getInventoryUseCase: GetInventoryUseCase,

) :
    ViewModel() {
    var steamId: MutableState<String> = mutableStateOf("")
    lateinit var inventoryItemList: MutableList<InventoryItem>

    suspend fun getInventory(resultViewError: MutableState<ViewError>): Result<Inventory> {
        resultViewError.value = SteamIdValidation.isSteamIdVerify(steamId.value)
        return when (resultViewError.value.isError.value) {
            true -> Result.Error(Exception())
            false -> getInventoryUseCase.invoke(steamId.value)
        }
    }
}
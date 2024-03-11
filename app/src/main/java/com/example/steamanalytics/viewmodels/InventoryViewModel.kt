package com.example.steamanalytics.viewmodels

import android.net.Uri
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.domain.entities.Inventory
import com.example.domain.entities.Item
import com.example.domain.utils.Result
import com.example.domain.use_case.GetInventoryUseCase
import com.example.steamanalytics.utils.ViewError
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InventoryViewModel @Inject constructor(
    private val getInventoryUseCase: GetInventoryUseCase
) :
    ViewModel() {
    var steamId: MutableState<String> = mutableStateOf("")
    lateinit var itemList: MutableList<Item>

    suspend fun getInventory(resultViewError: MutableState<ViewError>): Result<Inventory> {
        return getInventoryUseCase.invoke(steamId.value)
    }
}
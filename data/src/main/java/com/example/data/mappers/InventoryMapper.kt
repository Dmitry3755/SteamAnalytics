package com.example.data.mappers

import com.example.data.entities.InventoryApiResponse
import com.example.domain.entities.Inventory

fun InventoryApiResponse.toInventory(): Inventory {
    return Inventory(
        assets = this.assets.map { it.toAssets() },
        descriptions = this.descriptions.map { it.toItem() }
    )
}
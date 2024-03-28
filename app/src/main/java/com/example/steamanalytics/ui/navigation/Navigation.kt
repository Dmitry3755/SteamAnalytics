package com.example.steamanalytics.ui.navigation

sealed class Navigation(val route: String) {
    object SteamIdScreen : Navigation("steam_id_screen")
    object InventoryScreen : Navigation("inventory_screen")
    object ItemScreen : Navigation("item_screen")
}

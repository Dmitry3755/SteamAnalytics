package com.example.steamanalytics.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.steamanalytics.ui.screen.InventoryScreen
import com.example.steamanalytics.ui.screen.SteamIdScreen
import com.example.steamanalytics.viewmodels.AppViewModel
import com.example.steamanalytics.viewmodels.InventoryViewModel

@Composable
fun NavGraph(viewModel: InventoryViewModel, appViewModel: AppViewModel, context: Context) {
    val navigationController = rememberNavController()
    NavHost(
        navController = navigationController,
        startDestination = Navigation.SteamIdScreen.route
    ) {
        composable(route = Navigation.SteamIdScreen.route) {
            SteamIdScreen(navigationController, viewModel, appViewModel, context)
        }
        composable(route = Navigation.InventoryScreen.route) {
            InventoryScreen(navigationController, viewModel, appViewModel)
        }
    }
}
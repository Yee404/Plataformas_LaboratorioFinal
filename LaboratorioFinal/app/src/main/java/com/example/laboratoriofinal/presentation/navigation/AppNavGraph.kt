package com.example.laboratoriofinal.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "asset_list") {
        composable("asset_list") { AssetListScreen(navController) }
        composable("asset_detail/{id}") { backStackEntry ->
            val assetId = backStackEntry.arguments?.getString("id")
            AssetDetailScreen(navController, assetId)
        }
    }
}

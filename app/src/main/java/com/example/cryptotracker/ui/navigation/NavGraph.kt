package com.example.cryptotracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptotracker.ui.screens.detail.AssetDetailScreen
import com.example.cryptotracker.ui.screens.list.AssetListScreen

@Composable
fun NavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            AssetListScreen { asset ->
                navController.navigate("detail/${asset.id}")
            }
        }
        composable("detail/{assetId}") { backStackEntry ->
            val assetId = backStackEntry.arguments?.getString("assetId") ?: return@composable
            AssetDetailScreen(assetId)
        }
    }
}
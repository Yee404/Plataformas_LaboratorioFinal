package com.example.laboratoriofinal.presentation.navigation

sealed class NavigationRoutes(val route: String) {
    object AssetList : NavigationRoutes("asset_list")
    object AssetDetail : NavigationRoutes("asset_detail/{id}")
}

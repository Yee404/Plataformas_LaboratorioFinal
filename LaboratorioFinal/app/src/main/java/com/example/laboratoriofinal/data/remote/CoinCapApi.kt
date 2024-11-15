package com.example.laboratoriofinal.data.remote

interface CoinCapApi {
    suspend fun getAssets(): List<Asset>
    suspend fun getAssetDetail(id: String): AssetDetail
}

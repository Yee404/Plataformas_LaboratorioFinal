package com.example.laboratoriofinal.data.repository

import com.example.laboratoriofinal.data.local.AssetDao
import com.example.laboratoriofinal.data.local.AssetEntity
import com.example.laboratoriofinal.data.remote.CoinCapApi

class AssetRepository(
    private val api: CoinCapApi,
    private val dao: AssetDao
) {
    suspend fun getAssets(): List<AssetEntity> {
        return try {
            val assets = api.getAssets()
            dao.insertAssets(assets.map { it.toEntity() })
            assets.map { it.toEntity() }
        } catch (e: Exception) {
            dao.getAssets()
        }
    }
}

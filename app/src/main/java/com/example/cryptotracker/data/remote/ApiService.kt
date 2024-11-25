package com.example.cryptotracker.data.remote

import com.example.cryptotracker.data.local.AssetEntity
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class ApiService(private val client: HttpClient) {
    suspend fun getAssets(): List<AssetEntity> {
        //return client.get("https://api.coincap.io/v2/assets").body()
    return emptyList()
    }
}

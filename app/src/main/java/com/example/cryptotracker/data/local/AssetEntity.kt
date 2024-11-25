package com.example.cryptotracker.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "assets")
data class AssetEntity(
    @PrimaryKey val id: String,
    // Listado de Assets Mostrará la siguiente información de cada criptomoneda:
    val name: String,
    val symbol: String,
    val priceUsd: Double,
    val changePercent24Hr: Double,

    // Perfil del Asset Además de los campos anteriores, mostrará:
    val supply: Double,
    val maxSupply: Double?,
    val marketCapUsd: Double
)
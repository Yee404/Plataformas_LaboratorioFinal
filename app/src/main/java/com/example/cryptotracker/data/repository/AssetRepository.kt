package com.example.cryptotracker.data.repository

import com.example.cryptotracker.data.local.AssetDao
import com.example.cryptotracker.data.local.AssetEntity
import com.example.cryptotracker.data.remote.ApiService
import com.example.cryptotracker.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AssetRepository(
    private val apiService: ApiService,
    private val assetDao: AssetDao
) {
    fun getAssets(): Flow<Resource<List<AssetEntity>>> = flow {
        emit(Resource.Loading())

        try {
            val remoteAssets = apiService.getAssets()
            assetDao.insertAll(remoteAssets)
            val localAssets = assetDao.getAllAssets()
            emit(Resource.Success(localAssets))
        } catch (e: Exception) {
            val cachedAssets = assetDao.getAllAssets()
            if (cachedAssets.isNotEmpty()) {
                emit(Resource.Success(cachedAssets))
            } else {
                emit(Resource.Error("Error. Failed to fetch assets"))
            }
        }
    }
}
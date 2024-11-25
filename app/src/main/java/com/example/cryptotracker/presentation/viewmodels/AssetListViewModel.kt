package com.example.cryptotracker.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptotracker.data.local.AssetEntity
import com.example.cryptotracker.data.repository.AssetRepository
import com.example.cryptotracker.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AssetListViewModel(
    private val repository: AssetRepository
) : ViewModel() {

    private val _assets = MutableStateFlow<List<AssetEntity>>(emptyList())
    val assets: StateFlow<List<AssetEntity>> get() = _assets

    init {
        fetchAssets()
    }

    private fun fetchAssets() {
        viewModelScope.launch {
            repository.getAssets().collect { resource ->
                when (resource) {
                    is Resource.Success -> _assets.value = resource.data ?: emptyList()
                    is Resource.Error -> {
                    }
                    is Resource.Loading -> {
                    }
                }
            }
        }
    }
}
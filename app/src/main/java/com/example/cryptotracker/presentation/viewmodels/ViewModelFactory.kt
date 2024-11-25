package com.example.cryptotracker.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cryptotracker.data.repository.AssetRepository

class ViewModelFactory(
    private val repository: AssetRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AssetListViewModel::class.java)) {
            return AssetListViewModel(repository) as T
        }
        throw IllegalArgumentException("Error. Unknown ViewModel class")
    }
}

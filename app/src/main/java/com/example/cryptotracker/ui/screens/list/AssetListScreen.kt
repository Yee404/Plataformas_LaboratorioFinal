package com.example.cryptotracker.ui.screens.list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cryptotracker.data.local.AssetEntity
import com.example.cryptotracker.presentation.viewmodels.AssetListViewModel

@Composable
fun AssetListScreen(viewModel: AssetListViewModel = viewModel(), onAssetClick: (AssetEntity) -> Unit) {
    val assets by viewModel.assets.collectAsState(initial = emptyList())

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(assets) { asset ->
            Text(
                text = "${asset.name} - $${asset.priceUsd}",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

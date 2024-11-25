package com.example.cryptotracker.ui.screens.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AssetDetailScreen(assetId: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Asset ID: $assetId", modifier = Modifier.padding(bottom = 8.dp))
    }
}
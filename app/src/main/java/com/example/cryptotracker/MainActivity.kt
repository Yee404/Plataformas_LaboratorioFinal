package com.example.cryptotracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cryptotracker.ui.theme.CryptoTrackerTheme
import com.example.cryptotracker.data.local.AppDatabase
import com.example.cryptotracker.data.remote.ApiService
import com.example.cryptotracker.data.repository.AssetRepository
import com.example.cryptotracker.ui.screens.list.AssetListScreen
import io.ktor.client.HttpClient

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Instancia del ApiService y AppDatabase (pendiente)
        //val apiService = ApiService(httpClient) //cliente Ktor configurado
        val database = AppDatabase.getInstance(this)
        val assetDao = database.assetDao()
        //val repository = AssetRepository(apiService, assetDao)

        setContent {
            //AssetListScreen(repository = repository, onAssetClick = { asset ->

            }
        }
    }


// pendiente

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CryptoTrackerTheme {
        Greeting("Android")
    }
}
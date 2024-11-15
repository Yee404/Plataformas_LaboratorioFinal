package com.example.laboratoriofinal.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.kotlinx.serializer.KotlinxSerializer

object NetworkModule {
    val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }
}

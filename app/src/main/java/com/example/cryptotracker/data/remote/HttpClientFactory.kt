package com.example.cryptotracker.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object HttpClientFactory {
    fun create(): HttpClient {
        return HttpClient(CIO) {
            // Logging para depuración
            install(Logging) {
                level = LogLevel.ALL
                logger = Logger.ANDROID
            }

            // Configuración de Content Negotiation para JSON
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true // Ignora campos desconocidos en JSON
                    }
                )
            }

            // Configuración predeterminada para Content-Type
            defaultRequest {
                contentType(ContentType.Application.Json)
            }
        }
    }
}


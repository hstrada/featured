package io.example.toggled.http

import java.time.Duration


interface HttpService {
    suspend fun get(
        uri: String,
        time: Duration
    ): String
}
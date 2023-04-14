package io.example.toggled.http


interface HttpService {
    suspend fun get(
        uri: String,
    ): String
}
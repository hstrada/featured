package io.example.toggled.cache

interface CacheService {
    fun set(key: String, value: String)

    fun get(key: String): String?
}
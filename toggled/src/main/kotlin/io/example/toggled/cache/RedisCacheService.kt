package io.example.toggled.cache

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
class RedisCacheService(
    private val reactiveRedisTemplate: RedisTemplate<String, String>,
) : CacheService {
    override fun set(key: String, value: String) {
        reactiveRedisTemplate.opsForValue().set(key, value)
    }

    override fun get(key: String): String? = reactiveRedisTemplate.opsForValue().get(key)
}
package io.example.toggled.cache

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
class RedisCacheService(
    private val redisTemplate: RedisTemplate<String, String>,
) : CacheService {
    override fun set(key: String, value: String) {
        redisTemplate.opsForValue().set(key, value)
    }

    override fun get(key: String): String? = redisTemplate.opsForValue().get(key)
}
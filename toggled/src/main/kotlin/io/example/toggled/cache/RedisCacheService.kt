package io.example.toggled.cache

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service
import java.time.Duration


@Service
class RedisCacheService(
    private val redisTemplate: RedisTemplate<String, String>,
) : CacheService {
    override fun set(key: String, value: String, time: Duration) {
        redisTemplate.opsForValue().set(key, value, time)
    }

    override fun get(key: String): String? = redisTemplate.opsForValue().get(key)
}
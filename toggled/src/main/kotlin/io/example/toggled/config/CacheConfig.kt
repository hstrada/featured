package io.example.toggled.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.StringRedisSerializer





@Configuration
class CacheConfig {

    @Bean
    fun redisClient(): LettuceConnectionFactory? =
        LettuceConnectionFactory(RedisStandaloneConfiguration("localhost", 6379))

    @Bean
    fun redisTemplate(redisClient: RedisConnectionFactory?): RedisTemplate<String, String>? {
        val template = RedisTemplate<String, String>()
        template.setConnectionFactory(redisClient!!)
        template.keySerializer = StringRedisSerializer()
        template.valueSerializer = StringRedisSerializer()
        return template
    }

}

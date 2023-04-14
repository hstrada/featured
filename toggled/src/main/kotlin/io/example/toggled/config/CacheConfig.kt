package io.example.toggled.config

import io.example.toggled.feature.FeatureService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.RedisSerializationContext.RedisSerializationContextBuilder
import org.springframework.data.redis.serializer.StringRedisSerializer


@Configuration
class CacheConfig {

    @Bean
    fun redisClient(): LettuceConnectionFactory? =
        LettuceConnectionFactory(RedisStandaloneConfiguration("localhost", 6379))

    @Bean
    fun reactiveRedisTemplate(
        factory: ReactiveRedisConnectionFactory?
    ): ReactiveRedisTemplate<String, FeatureService.Feature>? {
        val keySerializer = StringRedisSerializer()
        val valueSerializer: Jackson2JsonRedisSerializer<FeatureService.Feature> =
            Jackson2JsonRedisSerializer(FeatureService.Feature::class.java)
        val builder: RedisSerializationContextBuilder<String, FeatureService.Feature> =
            RedisSerializationContext.newSerializationContext(keySerializer)
        val context: RedisSerializationContext<String, FeatureService.Feature> = builder.value(valueSerializer).build()
        return ReactiveRedisTemplate(factory!!, context)
    }

}

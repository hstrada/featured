package io.example.toggled.feature

import arrow.core.Either
import arrow.core.raise.either
import io.example.toggled.config.CacheConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Service
class DefaultFeatureService(
    private val redisTemplate: ReactiveRedisTemplate<String, String>,
    private val client: WebClient
) : FeatureService {

    override suspend fun fetchFeature(featureName: FeatureService.FeatureName): Either<Exception, FeatureService.Feature> =
        either<Exception, FeatureService.Feature> {
            client
                .get()
                .uri("/api/toggles/search?name=${featureName.name}")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .awaitBody()
        }.onRight {
            redisTemplate.opsForValue().set(it.name, it.toString())
        }

}
package io.example.toggled.feature

import io.example.toggled.cache.CacheService
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Service
class DefaultFeatureService(
    private val cache: CacheService,
    private val client: WebClient
) : FeatureService {

    override suspend fun fetchFeature(featureName: FeatureService.FeatureName): FeatureService.Feature {
        val feature: FeatureService.Feature = client
            .get()
            .uri("/api/toggles/search?name=${featureName.name}")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .awaitBody()

        feature.also {
            cache.set(it.name, it.status)
        }

        return feature
    }

}
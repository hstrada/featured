package io.example.toggled.feature

import io.example.toggled.cache.CacheService
import io.example.toggled.ext.JSON
import io.example.toggled.http.SpringWebFluxHttpService
import org.springframework.stereotype.Service

@Service
class DefaultFeatureHandler(
    private val cache: CacheService,
    private val client: SpringWebFluxHttpService
) : FeatureHandler {

    override suspend fun fetchFeature(featureName: FeatureHandler.FeatureName): FeatureHandler.Feature? {
        val feature = client.get("/api/toggles/search?name=${featureName.name}")

        val parsedResponse = JSON.parse<FeatureHandler.Feature>(feature)

        feature.also {
            cache.set(parsedResponse.name, parsedResponse.status)
        }

        return parsedResponse
    }

}
package io.example.toggled.feature

import arrow.core.Either
import arrow.core.raise.either
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Service
class DefaultFeatureService : FeatureService {

    @Autowired
    lateinit var client: WebClient

    @Cacheable("feature", key = "#featureName")
    override suspend fun fetchFeature(featureName: FeatureService.FeatureName): Either<Exception, FeatureService.Feature> =
        either {
            client
                .get()
                .uri("/api/toggles/search?name=${featureName.name}")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .awaitBody()
        }

}
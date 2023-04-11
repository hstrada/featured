package io.example.toggled.feature

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono

@Service
class DefaultFeatureService : FeatureService {

    @Autowired
    lateinit var client: WebClient

    override suspend fun isEnabled(featureName: FeatureService.FeatureName): Boolean {
        val feature = client
            .get()
            .uri("/api/toggles/search?name=Feature_A1")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .awaitBody<FeatureService.Feature>()
        return FeatureService.FeatureStatus.valueOf(feature.status) == FeatureService.FeatureStatus.ON
    }
}
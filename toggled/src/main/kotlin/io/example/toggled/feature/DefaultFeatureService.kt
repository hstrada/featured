package io.example.toggled.feature

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono

@Component
class DefaultFeatureService(
    private val client: WebClient
) : FeatureService {
    override suspend fun isEnabled(featureName: FeatureService.FeatureName): Mono<Boolean> =
        client
            .get()
            .uri("http://localhost:8080/api/toggles/search?name=Feature_A1")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono<FeatureService.Feature>()
            .map {
                FeatureService.FeatureStatus.valueOf(it.status) == FeatureService.FeatureStatus.ON
            }

}
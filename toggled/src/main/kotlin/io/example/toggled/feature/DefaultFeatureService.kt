package io.example.toggled.feature

import arrow.core.Either
import arrow.core.continuations.either
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

    override suspend fun fetchFeature(featureName: FeatureService.FeatureName): Either<Exception, FeatureService.Feature> =
        either {
            client
                .get()
                .uri("/api/toggles/search?name=Feature_A1")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .awaitBody()
        }

}
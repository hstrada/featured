package io.example.toggled.http

import io.example.toggled.cache.CacheService
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import java.time.Duration

@Service
class SpringWebFluxHttpService(
    private val cache: CacheService,
    private val client: WebClient
) : HttpService {
    override suspend fun get(uri: String, time: Duration): String {

        val dataFromCache = cache.get(uri)

        if (dataFromCache != null) return dataFromCache

        val request: String = client
            .get()
            .uri(uri)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .awaitBody()

        cache.set(uri, request, time)

        return request

    }
}
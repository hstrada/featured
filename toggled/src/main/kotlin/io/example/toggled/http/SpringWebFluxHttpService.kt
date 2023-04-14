package io.example.toggled.http

import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Service
class SpringWebFluxHttpService(
    private val client: WebClient
) : HttpService {
    override suspend fun get(uri: String): String =
        client
            .get()
            .uri(uri)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .awaitBody()
}
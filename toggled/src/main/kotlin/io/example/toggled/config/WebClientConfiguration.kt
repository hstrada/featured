package io.example.toggled.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfiguration {

    @Bean
    fun client() =
        WebClient
            .builder()
            .baseUrl("http://localhost:8080")
            .build()
}
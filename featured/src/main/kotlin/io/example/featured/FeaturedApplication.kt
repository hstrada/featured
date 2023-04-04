package io.example.featured

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FeaturedApplication

fun main(args: Array<String>) {
	runApplication<FeaturedApplication>(*args)
}

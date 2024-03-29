package io.example.toggled

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class ToggledApplication

fun main(args: Array<String>) {
	runApplication<ToggledApplication>(*args)
}

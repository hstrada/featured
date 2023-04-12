package io.example.toggled

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ToggledApplication

fun main(args: Array<String>) {
	runApplication<ToggledApplication>(*args)
}

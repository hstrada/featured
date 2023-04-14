package io.example.toggled.ext

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

val mapper = jacksonObjectMapper()

object JSON {
    inline fun <reified T> parse(value: String): T = mapper.readValue(value)
}
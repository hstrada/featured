package io.example.featured.resources

import io.example.featured.entities.Toggle
import io.example.featured.resources.toggles.PostToggleRequest
import io.example.featured.resources.toggles.toToggleModel
import io.example.featured.services.ToggleService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("toggles")
class ToggleResource (
    private val toggleService: ToggleService
        ) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createBook(@RequestBody @Valid request: PostToggleRequest) {
        toggleService.create(request.toToggleModel())
    }
}
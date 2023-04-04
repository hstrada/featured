package io.example.featured.resources

import io.example.featured.entities.PageResponse
import io.example.featured.entities.Toggle
import io.example.featured.resources.toggles.PostToggleRequest
import io.example.featured.resources.toggles.PutToggleRequest
import io.example.featured.resources.toggles.toPageResponse
import io.example.featured.resources.toggles.toToggleModel
import io.example.featured.services.ToggleService
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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
    fun createToggle(@RequestBody @Valid request: PostToggleRequest) {
        toggleService.create(request.toToggleModel())
    }

    @GetMapping
    fun findAll(@PageableDefault(page = 0, size = 10) pageable: Pageable): PageResponse<Toggle> {
        return toggleService.findAll(pageable).toPageResponse()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): Toggle = toggleService.findById(id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateById(@PathVariable id: Int, @RequestBody toogle: PutToggleRequest) {
        val toggleSaved = toggleService.findById(id)
        toggleService.update(toogle.toToggleModel(toggleSaved))
    }
}
package io.example.featured.resources.toggles

import io.example.featured.entities.PageResponse
import io.example.featured.entities.Toggle
import io.example.featured.enums.ToggleStatus
import org.springframework.data.domain.Page

fun PostToggleRequest.toToggleModel(): Toggle =
    Toggle(
        name = this.name,
        status = ToggleStatus.valueOf(this.status)
    )

fun PutToggleRequest.toToggleModel(previousValue: Toggle): Toggle {
    return Toggle(
        id = previousValue.id,
        name = this.name,
        status = ToggleStatus.valueOf(this.status)
    )
}

fun <T> Page<T>.toPageResponse(): PageResponse<T> {
    return PageResponse(
        this.content,
        this.number,
        this.totalElements,
        this.totalPages
    )
}
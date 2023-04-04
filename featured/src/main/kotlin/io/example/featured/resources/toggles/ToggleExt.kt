package io.example.featured.resources.toggles

import io.example.featured.entities.Toggle
import io.example.featured.enums.ToggleStatus

fun PostToggleRequest.toToggleModel(): Toggle =
    Toggle(
        name = this.name,
        status = ToggleStatus.valueOf(this.status)
    )
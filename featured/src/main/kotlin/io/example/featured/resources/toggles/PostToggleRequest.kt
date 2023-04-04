package io.example.featured.resources.toggles

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class PostToggleRequest (
    @field:NotEmpty(message = "Name is mandatory.")
    var name: String,
    @field:Size(min = 2, max = 3, message = "Value is not valid.")
    @field:NotNull(message = "Status is mandatory.")
    var status: String
)
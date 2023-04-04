package io.example.featured.resources.toggles

data class PutToggleRequest(
    var name: String,
    var status: String,
)
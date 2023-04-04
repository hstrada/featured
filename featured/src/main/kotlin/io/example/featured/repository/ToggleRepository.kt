package io.example.featured.repository

import io.example.featured.entities.Toggle
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

interface ToggleRepository : CrudRepository <Toggle, Int> {
    fun findAll(pageable: Pageable): Page<Toggle>
}
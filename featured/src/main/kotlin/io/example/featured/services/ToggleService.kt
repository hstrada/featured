package io.example.featured.services

import io.example.featured.entities.Toggle
import io.example.featured.enums.ToggleStatus
import io.example.featured.repository.ToggleRepository
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Service
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

@Service
class ToggleService(
    private val toggleRepository: ToggleRepository
) {

    fun create(toggle: Toggle) {
        toggleRepository.save(toggle)
    }

    fun findAll(pageable: Pageable): Page<Toggle> {
        return toggleRepository.findAll(pageable)
    }

    fun findById(id: Int): Toggle {
        return toggleRepository.findById(id)
            .orElseThrow { ChangeSetPersister.NotFoundException() }
    }

    fun update(toggle: Toggle) {
        toggleRepository.save(toggle)
    }

}
package io.example.toggled.resources

import io.example.toggled.feature.FeatureService
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("toggles")
class ToggledController(
    private val feature: FeatureService
) {

    @GetMapping
    suspend fun feature() {
        feature.isEnabled(FeatureService.FeatureName.FeatureA1)
        feature.isEnabled(FeatureService.FeatureName.FeatureC)

        ok()
    }

}
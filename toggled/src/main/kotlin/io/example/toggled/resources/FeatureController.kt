package io.example.toggled.resources

import io.example.toggled.feature.FeatureHandler
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("features")
class FeatureController(
    private val feature: FeatureHandler
) {

    @GetMapping
    suspend fun feature() {
        feature.isEnabled(FeatureHandler.FeatureName.FeatureA1)
        feature.isEnabled(FeatureHandler.FeatureName.FeatureC)

        ok()
    }

}
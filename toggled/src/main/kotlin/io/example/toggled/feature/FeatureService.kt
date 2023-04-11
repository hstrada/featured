package io.example.toggled.feature

import reactor.core.publisher.Mono

interface FeatureService {

    sealed class FeatureName(val name: String) {
        object FeatureA1 : FeatureName("Feature_A1")
    }

    enum class FeatureStatus { ON, OFF }

    data class Feature(
        val name: String,
        val status: String,
    )

    suspend fun isEnabled(featureName: FeatureName): Boolean
}
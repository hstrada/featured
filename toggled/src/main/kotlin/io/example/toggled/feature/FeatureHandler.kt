package io.example.toggled.feature

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

interface FeatureHandler {

    sealed class FeatureName(val name: String) {
        object FeatureA1 : FeatureName("Feature_A1")
        object FeatureC : FeatureName("feature_c")
    }

    enum class FeatureStatus { ON, OFF }

    @JsonIgnoreProperties(value = ["id"])
    data class Feature(
        val name: String,
        val status: String,
    )

    suspend fun fetchFeature(featureName: FeatureName): Feature?

    suspend fun isEnabled(featureName: FeatureName): Boolean =
        fetchFeature(featureName)?.status?.let { FeatureStatus.valueOf(it) } == FeatureStatus.ON
}
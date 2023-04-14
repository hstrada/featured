package io.example.toggled.feature

interface FeatureService {

    sealed class FeatureName(val name: String) {
        object FeatureA1 : FeatureName("Feature_A1")
        object FeatureC : FeatureName("feature_c")
    }

    enum class FeatureStatus { ON, OFF }

    data class Feature(
        val name: String,
        val status: String,
    )

    suspend fun fetchFeature(featureName: FeatureName): Feature

    suspend fun isEnabled(featureName: FeatureName): Boolean =
        FeatureStatus.valueOf(fetchFeature(featureName).status) == FeatureStatus.ON
}
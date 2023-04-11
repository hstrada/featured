package io.example.toggled.feature

import arrow.core.Either
import arrow.core.getOrElse
import reactor.core.publisher.Mono

interface FeatureService {

    sealed class FeatureName(val name: String) {
        object FeatureA1 : FeatureName("Feature_A1")
    }

    enum class FeatureStatus { ON, OFF }

    data class Feature(
        val name: FeatureName,
        val status: String,
    )

    suspend fun fetchFeature(featureName: FeatureName):
            Either<Exception, Feature>

    suspend fun isEnabled(featureName: FeatureName): Boolean =
        fetchFeature(featureName)
            .map { FeatureStatus.valueOf(it.status) == FeatureStatus.ON }
            .getOrElse { false }
}
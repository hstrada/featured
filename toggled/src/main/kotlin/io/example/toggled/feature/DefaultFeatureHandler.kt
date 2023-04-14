package io.example.toggled.feature

import io.example.toggled.ext.FIVE_MINUTES
import io.example.toggled.ext.JSON
import io.example.toggled.http.HttpService
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class DefaultFeatureHandler(
    private val client: HttpService
) : FeatureHandler {

    override suspend fun fetchFeature(featureName: FeatureHandler.FeatureName): FeatureHandler.Feature? {

        val feature = client.get(
            uri = "/api/toggles/search?name=${featureName.name}",
            time = FIVE_MINUTES
        )

        return JSON.parse<FeatureHandler.Feature>(feature)
    }

}
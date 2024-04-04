package com.amadiyawa.feature_users.data.datasource.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class LocationApiModel(
    @SerialName("street") val street: StreetApiModel,
    @SerialName("city") val city: String,
    @SerialName("state") val state: String,
    @SerialName("country") val country: String,
    @SerialName("postcode") val postcode: String,
    @SerialName("coordinates") val coordinates: CoordinatesApiModel,
    @SerialName("timezone") val timezone: TimezoneApiModel
)
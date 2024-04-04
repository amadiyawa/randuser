package com.amadiyawa.feature_users.data.datasource.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CoordinatesApiModel(
    @SerialName("latitude") val latitude: String,
    @SerialName("longitude") val longitude: String
)
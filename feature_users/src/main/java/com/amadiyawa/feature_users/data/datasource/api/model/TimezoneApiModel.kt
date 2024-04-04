package com.amadiyawa.feature_users.data.datasource.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class TimezoneApiModel(
    @SerialName("offset") val offset: String,
    @SerialName("description") val description: String
)
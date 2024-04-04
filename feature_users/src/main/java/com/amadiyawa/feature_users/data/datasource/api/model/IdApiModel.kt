package com.amadiyawa.feature_users.data.datasource.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class IdApiModel(
    @SerialName("name") val name: String,
    @SerialName("value") val value: String?
)
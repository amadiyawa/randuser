package com.amadiyawa.feature_users.data.datasource.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class StreetApiModel(
    @SerialName("number") val number: Int,
    @SerialName("name") val name: String
)
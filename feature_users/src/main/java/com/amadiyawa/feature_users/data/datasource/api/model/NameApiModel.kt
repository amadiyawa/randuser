package com.amadiyawa.feature_users.data.datasource.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class NameApiModel(
    @SerialName("title") val title: String,
    @SerialName("first") val first: String,
    @SerialName("last") val last: String
)
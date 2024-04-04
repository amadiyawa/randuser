package com.amadiyawa.feature_users.data.datasource.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PictureApiModel(
    @SerialName("large") val large: String,
    @SerialName("medium") val medium: String,
    @SerialName("thumbnail") val thumbnail: String
)
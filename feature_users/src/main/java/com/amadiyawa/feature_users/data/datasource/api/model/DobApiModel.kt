package com.amadiyawa.feature_users.data.datasource.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class DobApiModel(
    @SerialName("date") val date: String,
    @SerialName("age") val age: Int
)
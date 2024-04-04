package com.amadiyawa.feature_users.data.datasource.api.response

import com.amadiyawa.feature_users.data.datasource.api.model.InfoApiModel
import com.amadiyawa.feature_users.data.datasource.api.model.UserApiModel
import com.amadiyawa.feature_users.data.datasource.api.model.UserListApiModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class UserListResponse(
    @SerialName("results") val results: UserListApiModel,
    @SerialName("info") val info: InfoApiModel
)
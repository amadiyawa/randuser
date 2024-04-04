package com.amadiyawa.feature_users.data.datasource.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class UserApiModel(
    @SerialName("gender") val gender : String,
    @SerialName("name") val name : NameApiModel,
    @SerialName("location") val location : LocationApiModel,
    @SerialName("email") val email : String,
    @SerialName("login") val login : LoginApiModel,
    @SerialName("dob") val dob : DobApiModel,
    @SerialName("registered") val registered : RegisteredApiModel,
    @SerialName("phone") val phone : String,
    @SerialName("cell") val cell : String,
    @SerialName("id") val id : IdApiModel,
    @SerialName("picture") val picture : PictureApiModel,
    @SerialName("nat") val nat : String
)
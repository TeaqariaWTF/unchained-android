package com.github.livingwithhippos.unchained.authentication.model

import com.github.livingwithhippos.unchained.utilities.OPEN_SOURCE_CLIENT_ID
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

@JsonClass(generateAdapter = true)
data class Authentication(
    @Json(name = "device_code")
    val deviceCode: String,
    @Json(name = "user_code")
    val userCode: String,
    @Json(name = "interval")
    val interval: Int,
    @Json(name = "expires_in")
    val expiresIn: Int,
    @Json(name = "verification_url")
    val verificationUrl: String,
    @Json(name = "direct_verification_url")
    val directVerificationUrl: String
)

@JsonClass(generateAdapter = true)
data class Secrets(
    @Json(name = "client_id")
    val clientId: String,
    @Json(name = "client_secret")
    val clientSecret: String
)

interface AuthenticationApi {

    @GET("device/code")
    suspend fun getAuthentication(
        @Query("client_id") id: String = OPEN_SOURCE_CLIENT_ID,
        @Query("new_credentials") newCredentials: String = "yes"
    ): Response<Authentication>

    @GET("/device/credentials")
    suspend fun getSecrets(
        @Query("client_id") id: String = OPEN_SOURCE_CLIENT_ID,
        @Query("code") deviceCode: String
    ): Response<Secrets>
}
package com.github.livingwithhippos.unchained.user.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header


@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "id")
    val id: Int,
    @Json(name = "username")
    val username: String,
    @Json(name = "email")
    val email: String,
    @Json(name = "points")
    val points: Int,
    @Json(name = "locale")
    val locale: String,
    @Json(name = "avatar")
    val avatar: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "premium")
    val premium: Int,
    @Json(name = "expiration")
    val expiration: String
)

interface UserApi {
    @GET("user")
    suspend fun getUser(@Header("Authorization") token: String): Response<User>
}
package com.coreman.moviesmvp.entity

import com.google.gson.annotations.SerializedName

data class TrailerMovie(
        @SerializedName("results") val results: List<Result>
)

data class Result(
        @SerializedName("id") val id: String,
        @SerializedName("key") val key: String,
        @SerializedName("name") val name: String,
        @SerializedName("site") val site: String,
        @SerializedName("size") val size: Int,
        @SerializedName("type") val type: String
)
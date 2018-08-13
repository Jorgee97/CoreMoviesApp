package com.coreman.moviesmvp.entity

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class Movie(
        @SerializedName("id") val id: Int,
        @SerializedName("vote_average") val voteAverage: Double,
        @SerializedName("title") val title: String,
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("original_title") val originalTitle: String,
        @SerializedName("genre_ids") val genresIds: List<Int>
)
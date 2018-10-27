package com.coreman.moviesmvp.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class Movie (
        @PrimaryKey
        @SerializedName("id") val id: Int,

        @SerializedName("vote_average") val voteAverage: Double,
        @SerializedName("title") val title: String,
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("original_title") val originalTitle: String,
        @SerializedName("genre_ids") val genresIds: List<Int>
)
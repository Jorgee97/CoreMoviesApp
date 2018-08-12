package com.coreman.moviesmvp.entity

import com.google.gson.annotations.SerializedName

data class GenreList(
        @SerializedName("genres") val genres: List<Genre>
)
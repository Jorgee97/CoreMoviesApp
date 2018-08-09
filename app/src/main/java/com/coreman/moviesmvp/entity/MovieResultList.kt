package com.coreman.moviesmvp.entity

import com.google.gson.annotations.SerializedName

class MovieResultList {
    @SerializedName("results")
    lateinit var results: List<Movie>
}
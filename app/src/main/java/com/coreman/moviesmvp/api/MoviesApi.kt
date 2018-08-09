package com.coreman.moviesmvp.api

import com.coreman.moviesmvp.entity.MovieResultList
import io.reactivex.Observable
import retrofit2.http.GET

interface MoviesApi {
    @GET("movie/popular")
    fun getPopularMovies(): Observable<MovieResultList>

}
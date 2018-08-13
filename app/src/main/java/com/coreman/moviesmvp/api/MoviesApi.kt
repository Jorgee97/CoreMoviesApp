package com.coreman.moviesmvp.api

import com.coreman.moviesmvp.entity.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesApi {
    @GET("movie/popular")
    fun getPopularMovies(): Observable<MovieResultList>

    @GET("genre/movie/list")
    fun getGenres(): Observable<GenreList>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") movieId: Int): Observable<MovieDetails>

    @GET("movie/{movie_id}/videos")
    fun getMovieVideos(@Path("movie_id") movieId: Int): Observable<TrailerMovie>
}
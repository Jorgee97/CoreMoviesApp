package com.coreman.moviesmvp.db

import com.coreman.moviesmvp.entity.Movie
import com.coreman.moviesmvp.entity.MovieCache
import io.reactivex.Observable

interface MoviesCache {
    fun save(movie: MovieCache)
    fun getAll() : Observable<List<MovieCache>>
}
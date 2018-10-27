package com.coreman.moviesmvp.db

import com.coreman.moviesmvp.entity.MovieCache
import io.reactivex.Observable

class FavoritesMovieCache(database: MovieDatabase) : MoviesCache {

    private val dao: MoviesDAO = database.getMoviesDao()

    override fun save(movie: MovieCache) {
        dao.saveMovie(movie)
    }

    override fun getAll(): Observable<List<MovieCache>> {
        return Observable.fromCallable { dao.getFavorites() }
    }
}
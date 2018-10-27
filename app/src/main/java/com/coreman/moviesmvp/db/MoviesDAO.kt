package com.coreman.moviesmvp.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.coreman.moviesmvp.entity.Movie
import com.coreman.moviesmvp.entity.MovieCache

@Dao
interface MoviesDAO {
    @Query("SELECT * FROM movies")
    fun getFavorites(): List<MovieCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovie(movie: MovieCache)
}
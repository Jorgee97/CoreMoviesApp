package com.coreman.moviesmvp.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.coreman.moviesmvp.entity.MovieCache

@Database(entities = [(MovieCache::class)], version = 2, exportSchema = false)
@TypeConverters(GenreConverter::class)
abstract class MovieDatabase: RoomDatabase() {
    abstract  fun getMoviesDao() : MoviesDAO

}
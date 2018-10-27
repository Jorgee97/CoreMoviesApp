package com.coreman.moviesmvp.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.coreman.moviesmvp.db.FavoritesMovieCache
import com.coreman.moviesmvp.db.MovieDatabase
import com.coreman.moviesmvp.db.MoviesCache
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(context: Context): MovieDatabase {
        return Room.databaseBuilder(context, MovieDatabase::class.java, "movies_db")
                .fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideFavoritesMovieCache(moviesDatabase: MovieDatabase) : MoviesCache {
        return FavoritesMovieCache(moviesDatabase)
    }
}
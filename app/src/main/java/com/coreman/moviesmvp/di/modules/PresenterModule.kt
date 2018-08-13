package com.coreman.moviesmvp.di.modules

import com.coreman.moviesmvp.ui.detail.DetailsMoviesActivity
import com.coreman.moviesmvp.ui.detail.DetailsMoviesPresenter
import com.coreman.moviesmvp.ui.popular.PopularMoviesPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {
    @Provides
    fun providesPopularMoviesPresenter(): PopularMoviesPresenter {
        return PopularMoviesPresenter()
    }

    @Provides
    fun providesDetailsMoviesPresenter(): DetailsMoviesPresenter {
        return DetailsMoviesPresenter()
    }
}
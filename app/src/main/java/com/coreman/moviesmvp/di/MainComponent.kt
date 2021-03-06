package com.coreman.moviesmvp.di

import com.coreman.moviesmvp.di.modules.AppModule
import com.coreman.moviesmvp.di.modules.DataModule
import com.coreman.moviesmvp.di.modules.NetworkModule
import com.coreman.moviesmvp.di.modules.PresenterModule
import com.coreman.moviesmvp.ui.detail.DetailsMoviesActivity
import com.coreman.moviesmvp.ui.detail.DetailsMoviesPresenter
import com.coreman.moviesmvp.ui.popular.PopularMoviesFragment
import com.coreman.moviesmvp.ui.popular.PopularMoviesPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, DataModule::class, PresenterModule::class])
interface MainComponent {
    fun inject(presenter: PopularMoviesPresenter)
    fun inject(popularMoviesFragment: PopularMoviesFragment)
    fun inject(detailsMoviesActivity: DetailsMoviesActivity)
    fun inject(detailsMoviesPresenter: DetailsMoviesPresenter)
}
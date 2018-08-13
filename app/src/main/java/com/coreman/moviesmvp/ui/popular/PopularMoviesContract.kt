package com.coreman.moviesmvp.ui.popular

import com.coreman.moviesmvp.BasePresenter
import com.coreman.moviesmvp.BaseView
import com.coreman.moviesmvp.entity.Genre
import com.coreman.moviesmvp.entity.Movie

interface PopularMoviesContract {

    interface View : BaseView {
        fun showPopularMovies(movies: List<Movie>, genres: List<Genre>)
        fun showProgressBar(show: Boolean)
    }

    interface Presenter : BasePresenter<View>{
        fun getPopularMovies()
    }
}
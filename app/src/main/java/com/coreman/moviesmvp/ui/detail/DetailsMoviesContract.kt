package com.coreman.moviesmvp.ui.detail

import com.coreman.moviesmvp.BasePresenter
import com.coreman.moviesmvp.BaseView
import com.coreman.moviesmvp.entity.MovieDetails

interface DetailsMoviesContract {
    interface View : BaseView {
        fun showMovieDetails(moviesDetails: MovieDetails)
        fun showLoading(show: Boolean)
    }

    interface Presenter: BasePresenter<View> {
        fun getMovieDetails(id: Int)
    }
}
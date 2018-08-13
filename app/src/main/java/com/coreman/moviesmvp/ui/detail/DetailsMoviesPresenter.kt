package com.coreman.moviesmvp.ui.detail

import android.util.Log
import com.coreman.moviesmvp.App
import com.coreman.moviesmvp.api.MoviesApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailsMoviesPresenter: DetailsMoviesContract.Presenter {

    @Inject
    lateinit var moviesApi: MoviesApi
    lateinit var view: DetailsMoviesContract.View

    init {
        App.instance.mainComponent.inject(this)
    }

    override fun attachView(view: DetailsMoviesContract.View) {
        this.view = view
    }

    override fun getMovieDetails(id: Int) {
        view.showLoading(true)
        moviesApi.getMovieDetails(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { movie ->
                            view.showMovieDetails(movie)
                            view.showLoading(false)
                        },
                        { e -> Log.e(e.message, e.stackTrace.toString()) }
                )
    }
}
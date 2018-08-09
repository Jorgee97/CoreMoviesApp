package com.coreman.moviesmvp.ui.popular

import android.util.Log
import com.coreman.moviesmvp.App
import com.coreman.moviesmvp.api.MoviesApi
import com.coreman.moviesmvp.entity.MovieResultList
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PopularMoviesPresenter: PopularMoviesContract.Presenter {

    @Inject
    lateinit var moviesApi: MoviesApi

    lateinit var view: PopularMoviesContract.View

    init {
        App.instance.mainComponent.inject(this)
    }

    override fun attachView(view: PopularMoviesContract.View) {
        this.view = view
    }

    override fun getPopularMovies() {
        val call: Observable<MovieResultList> = moviesApi.getPopularMovies()
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                        { movies -> view.showPopularMovies(movies.results) },
                        { e -> Log.e(e?.message, e?.stackTrace.toString())}
                )
    }
}
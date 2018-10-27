package com.coreman.moviesmvp.ui.detail

import android.graphics.Movie
import android.util.Log
import com.coreman.moviesmvp.App
import com.coreman.moviesmvp.api.MoviesApi
import com.coreman.moviesmvp.db.MovieDatabase
import com.coreman.moviesmvp.db.MoviesDAO
import com.coreman.moviesmvp.entity.MovieCache
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailsMoviesPresenter: DetailsMoviesContract.Presenter {

    @Inject
    lateinit var moviesApi: MoviesApi
    @Inject
    lateinit var movieDatabase: MovieDatabase

    private var moviesDAO: MoviesDAO
    lateinit var view: DetailsMoviesContract.View

    init {
        App.instance.mainComponent.inject(this)
        moviesDAO = movieDatabase.getMoviesDao()
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

    override fun saveMovie(movie: MovieCache) {
        Log.i("SaveMovie: ", movie.title)

        Observable.fromCallable { moviesDAO.saveMovie(movie) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ m ->
                    Log.i("SaveMovie", "Se guardo")
                },{ e ->
                    Log.e("SaveMovie", e.toString())
                })
    }
}
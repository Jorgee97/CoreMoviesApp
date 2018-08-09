package com.coreman.moviesmvp.ui.popular


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coreman.moviesmvp.App
import com.coreman.moviesmvp.R
import com.coreman.moviesmvp.entity.Movie
import javax.inject.Inject

class PopularMoviesFragment : Fragment(), PopularMoviesContract.View {

    @Inject
    lateinit var presenter: PopularMoviesPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_popular_movies, container, false)

        (activity?.application as App).mainComponent.inject(this)

        presenter.attachView(this)
        presenter.getPopularMovies()

        return view
    }

    override fun showPopularMovies(movies: List<Movie>) {
        movies.forEach { movie -> Log.i("Popular", movie.originalTitle) }
    }
}

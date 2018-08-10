package com.coreman.moviesmvp.ui.popular


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coreman.moviesmvp.App
import com.coreman.moviesmvp.R
import com.coreman.moviesmvp.entity.Movie
import kotlinx.android.synthetic.main.fragment_popular_movies.*
import javax.inject.Inject

class PopularMoviesFragment : Fragment(), PopularMoviesContract.View {

    @Inject
    lateinit var presenter: PopularMoviesPresenter

    private lateinit var adapter: PopularMoviesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_popular_movies, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        (activity?.application as App).mainComponent.inject(this)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movies_recycler.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false)
        movies_recycler.hasFixedSize()

        presenter.attachView(this)
        presenter.getPopularMovies()
    }

    override fun showPopularMovies(movies: List<Movie>) {
        movies.forEach { movie -> Log.i("Popular", movie.originalTitle) }
        adapter = PopularMoviesAdapter(movies)
        movies_recycler.adapter = adapter
    }
}

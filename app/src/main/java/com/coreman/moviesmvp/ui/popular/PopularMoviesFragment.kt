package com.coreman.moviesmvp.ui.popular


import android.content.Context
import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SnapHelper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coreman.moviesmvp.App
import com.coreman.moviesmvp.R
import com.coreman.moviesmvp.entity.Genre
import com.coreman.moviesmvp.entity.Movie
import com.coreman.moviesmvp.ui.detail.DetailsMoviesActivity
import com.coreman.moviesmvp.util.MOVIE_ID
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

        val snapHelper = LinearSnapHelper()
        movies_recycler.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false)
        movies_recycler.hasFixedSize()
        snapHelper.attachToRecyclerView(movies_recycler)

        presenter.attachView(this)
        presenter.getPopularMovies()
    }

    override fun showPopularMovies(movies: List<Movie>, genres: List<Genre>) {
        adapter = PopularMoviesAdapter(movies, genres) { movie, view ->
            val intent = Intent(context, DetailsMoviesActivity::class.java)
            intent.putExtra(MOVIE_ID, movie.id.toString())
            startActivity(intent)
        }
        movies_recycler.adapter = adapter
    }

    override fun showProgressBar(show: Boolean) {
        if (show) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.INVISIBLE
        }
    }
}

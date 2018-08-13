package com.coreman.moviesmvp.ui.detail

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.coreman.moviesmvp.App
import com.coreman.moviesmvp.BasePresenter
import com.coreman.moviesmvp.R
import com.coreman.moviesmvp.entity.MovieDetails
import com.coreman.moviesmvp.util.IMAGE_URL
import com.coreman.moviesmvp.util.IMAGE_URL_BACKDROP
import com.coreman.moviesmvp.util.MOVIE_ID
import kotlinx.android.synthetic.main.activity_details_movies.*
import javax.inject.Inject

class DetailsMoviesActivity : AppCompatActivity(), DetailsMoviesContract.View {

    @Inject
    lateinit var presenter: DetailsMoviesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movies)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        (application as App).mainComponent.inject(this)

        val movieId = intent.getStringExtra(MOVIE_ID)

        presenter.attachView(this)
        presenter.getMovieDetails(movieId.toInt())
    }

    override fun showLoading(show: Boolean) {
        when (show) {
            true -> progressBar.visibility = View.VISIBLE
            else -> progressBar.visibility = View.INVISIBLE
        }
    }

    override fun showMovieDetails(moviesDetails: MovieDetails) {
        Log.i("MOVIE: ", moviesDetails.title)
        movie_title.text = moviesDetails.title
        release_date_movie.text = moviesDetails.releaseDate
        adult_movie.text = if (moviesDetails.adult) "Yes" else "No"

        rating_movie.text = moviesDetails.voteAverage.toString()
        overview_movie.text = moviesDetails.overview

        var companiesProducer = ""
        moviesDetails.productionCompanies.forEach { producer ->
            companiesProducer += producer.name + " /"
        }
        company_movie.text = companiesProducer.dropLast(1)

        if (moviesDetails.tagline.isNotEmpty())
            tagline_movie.text = moviesDetails.tagline
        else
            tagline_movie.visibility = View.GONE

        Glide.with(this)
                .load(IMAGE_URL_BACKDROP + moviesDetails.backdropPath)
                .into(backdrop_image)
        Glide.with(this)
                .load(IMAGE_URL + moviesDetails.posterPath)
                .into(post_image)

    }

}

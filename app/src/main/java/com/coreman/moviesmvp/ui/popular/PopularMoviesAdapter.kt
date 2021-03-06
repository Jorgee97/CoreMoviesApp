package com.coreman.moviesmvp.ui.popular

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.coreman.moviesmvp.App
import com.coreman.moviesmvp.R
import com.coreman.moviesmvp.entity.Genre
import com.coreman.moviesmvp.entity.Movie
import com.coreman.moviesmvp.ui.detail.DetailsMoviesActivity
import com.coreman.moviesmvp.util.IMAGE_URL
import com.coreman.moviesmvp.util.MOVIE_ID
import kotlinx.android.synthetic.main.movie_item.view.*

class PopularMoviesAdapter(private val movies: List<Movie>, private val genres: List<Genre>,
                           private val onMovieSelected: (Movie, View) -> Unit):
        RecyclerView.Adapter<PopularMoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, genres, onMovieSelected)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie, genres: List<Genre>, listener: (Movie, View) -> Unit) = with(itemView) {
            title_movie.text = movie.title
            Glide.with(App.instance.applicationContext)
                    .load(IMAGE_URL + movie.posterPath)
                    .into(poster_image)

            var movieGenre = ""
            movie.genresIds.forEach { item ->
                genres.forEach { genre ->
                    if (item == genre.id)
                        movieGenre += genre.name + " /"
                }
            }
            genres_movie.text = movieGenre.dropLast(1)

            setOnClickListener { listener(movie, itemView) }
            btn_movie_details.setOnClickListener { listener(movie, itemView) }
        }
    }
}
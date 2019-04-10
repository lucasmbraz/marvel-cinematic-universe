package com.lucasmbraz.mcu.moviedetails

import com.lucasmbraz.mcu.model.movies
import javax.inject.Inject

class MovieDetailsPresenter @Inject constructor() {

    fun start(view: MovieDetailsView, movieId: String) {
        val movie = movies.first { it.id == movieId }
        view.showMovie(movie)
    }
}
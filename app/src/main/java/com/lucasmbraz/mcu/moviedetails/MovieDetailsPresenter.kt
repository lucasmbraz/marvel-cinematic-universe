package com.lucasmbraz.mcu.moviedetails

import com.lucasmbraz.mcu.model.movies

class MovieDetailsPresenter {

    fun start(view: MovieDetailsView, movieId: String) {
        val movie = movies.first { it.id == movieId }
        view.showMovie(movie)
    }
}
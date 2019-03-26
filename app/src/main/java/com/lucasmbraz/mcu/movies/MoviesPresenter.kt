package com.lucasmbraz.mcu.movies

import com.lucasmbraz.mcu.model.movies

class MoviesPresenter {
    fun start(view: MoviesView) {
        view.showMovies(movies)
    }
}
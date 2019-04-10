package com.lucasmbraz.mcu.movies

import com.lucasmbraz.mcu.model.movies
import javax.inject.Inject

class MoviesPresenter @Inject constructor() {
    fun start(view: MoviesView) {
        view.showMovies(movies)
    }
}
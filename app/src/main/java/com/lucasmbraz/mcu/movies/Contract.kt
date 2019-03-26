package com.lucasmbraz.mcu.movies

import com.lucasmbraz.mcu.model.Movie

interface MoviesView {
    fun showMovies(movies: List<Movie>)
}

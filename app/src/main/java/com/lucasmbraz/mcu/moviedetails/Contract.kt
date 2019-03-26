package com.lucasmbraz.mcu.moviedetails

import com.lucasmbraz.mcu.model.Movie

interface MovieDetailsView {
    fun showMovie(movie: Movie)
}
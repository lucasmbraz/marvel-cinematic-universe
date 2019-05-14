package com.lucasmbraz.mcu

import androidx.fragment.app.FragmentManager
import com.lucasmbraz.mcu.model.Movie
import com.lucasmbraz.mcu.moviedetails.MovieDetailsFragment
import com.lucasmbraz.mcu.movies.MoviesFragment

class PageChanger(private val fragmentManager: FragmentManager) {

    fun showMoviesFragment() {
        fragmentManager.beginTransaction()
            .replace(R.id.content, MoviesFragment())
            .commit()
    }

    fun showMovieDetailsFragment(movie: Movie) {
        val fragment = MovieDetailsFragment.newInstance(movieId = movie.id)
        fragmentManager.beginTransaction()
            .addToBackStack("MovieDetais")
            .replace(R.id.content, fragment)
            .commit()
    }
}
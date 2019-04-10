package com.lucasmbraz.mcu.movies

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.PagerSnapHelper
import com.lucasmbraz.mcu.PageIndicatorDecoration
import com.lucasmbraz.mcu.R
import com.lucasmbraz.mcu.model.Movie
import com.lucasmbraz.mcu.moviedetails.MovieDetailsFragment
import kotlinx.android.synthetic.main.fragment_movies.*

class MoviesFragment : Fragment(), MoviesView {

    private lateinit var presenter: MoviesPresenter

    override fun onAttach(context: Context?) {
        presenter = DaggerMoviesComponent.builder().build().presenter()
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context, HORIZONTAL, false)
        PagerSnapHelper().attachToRecyclerView(recyclerView)
    }

    override fun onStart() {
        super.onStart()
        presenter.start(this)
    }

    override fun showMovies(movies: List<Movie>) {
        recyclerView.adapter = MoviesAdapter(movies, ::navigateToMovieDetails)
        if (recyclerView.itemDecorationCount == 0) {
            recyclerView.addItemDecoration(PageIndicatorDecoration())
        }
    }

    private fun navigateToMovieDetails(movie: Movie) {
        val fragment = MovieDetailsFragment.newInstance(movieId = movie.id)
        fragmentManager?.beginTransaction()
            ?.addToBackStack("MovieDetais")
            ?.replace(R.id.content, fragment)
            ?.commit()
    }
}

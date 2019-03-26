package com.lucasmbraz.mcu.moviedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lucasmbraz.mcu.R
import com.lucasmbraz.mcu.model.Movie
import kotlinx.android.synthetic.main.fragment_movie_details.*

class MovieDetailsFragment : Fragment(), MovieDetailsView {

    private val presenter: MovieDetailsPresenter = MovieDetailsPresenter()

    companion object {
        private const val KEY_MOVIE_ID = "movieId"

        fun newInstance(movieId: String): MovieDetailsFragment {
            val fragment = MovieDetailsFragment()
            val args = Bundle()
            args.putString(KEY_MOVIE_ID, movieId)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onStart() {
        super.onStart()
        val movieId = checkNotNull(arguments?.getString(KEY_MOVIE_ID))
        presenter.start(this, movieId)
    }

    override fun showMovie(movie: Movie) {
        title.text = movie.title
    }
}
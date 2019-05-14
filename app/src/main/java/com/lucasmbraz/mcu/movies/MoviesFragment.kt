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
import com.lucasmbraz.mcu.MainActivity
import com.lucasmbraz.mcu.PageChanger
import com.lucasmbraz.mcu.PageIndicatorDecoration
import com.lucasmbraz.mcu.R
import com.lucasmbraz.mcu.model.Movie
import kotlinx.android.synthetic.main.fragment_movies.*
import javax.inject.Inject

class MoviesFragment : Fragment(), MoviesView {

    private val component by lazy { (activity as MainActivity).component }

    @Inject lateinit var presenter: MoviesPresenter
    @Inject lateinit var pageChanger: PageChanger

    override fun onAttach(context: Context?) {
        component.inject(this)
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

    override fun onStop() {
        super.onStop()
        presenter.stop()
    }

    override fun showMovies(movies: List<Movie>) {
        recyclerView.adapter = MoviesAdapter(movies, pageChanger::showMovieDetailsFragment)
        if (recyclerView.itemDecorationCount == 0) {
            recyclerView.addItemDecoration(PageIndicatorDecoration())
        }
    }
}

package com.lucasmbraz.mcu.movies


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.lucasmbraz.mcu.R
import com.lucasmbraz.mcu.model.Movie
import com.lucasmbraz.mcu.setPositionBias
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesAdapter(val movies: List<Movie>, private val clickListener: (Movie) -> Unit) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount() = movies.size

    inner class ViewHolder(view: View, val clickListener: (Movie) -> Unit) : RecyclerView.ViewHolder(view) {
        private val constraintLayout: ConstraintLayout = view.constraintLayout
        private val title: TextView = view.title
        private val moreButton: TextView = view.moreButton
        private val length: TextView = view.length
        private val backdrop: ImageView = view.backdrop

        fun bind(movie: Movie) {
            title.text = movie.title
            length.text = movie.length
            backdrop.setImageResource(movie.backdrop)
            moreButton.text = "more about " + movie.shortTitle

            constraintLayout.setPositionBias(
                viewId = title.id,
                vertical = movie.titlePositionBias.vertical,
                horizontal = movie.titlePositionBias.horizontal
            )

            itemView.setOnClickListener { clickListener(movie) }
        }
    }
}

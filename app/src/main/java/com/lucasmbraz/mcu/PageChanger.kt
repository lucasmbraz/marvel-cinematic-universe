package com.lucasmbraz.mcu

import androidx.fragment.app.FragmentManager
import com.lucasmbraz.mcu.movies.MoviesFragment

class PageChanger(private val fragmentManager: FragmentManager) {

    fun showMoviesFragment() {
        fragmentManager.beginTransaction()
            .replace(R.id.content, MoviesFragment())
            .commit()
    }
}
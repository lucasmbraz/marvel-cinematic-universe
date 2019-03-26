package com.lucasmbraz.mcu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lucasmbraz.mcu.movies.MoviesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        if (savedInstanceState == null) {
            navigateToMoviesFragment()
        }
    }

    private fun navigateToMoviesFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content, MoviesFragment())
            .commit()
    }
}

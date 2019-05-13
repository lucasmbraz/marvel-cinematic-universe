package com.lucasmbraz.mcu

import android.app.Application
import com.lucasmbraz.mcu.movies.di.DaggerMoviesComponent
import com.lucasmbraz.mcu.movies.di.MoviesComponent

class App : Application() {

    val moviesComponent: MoviesComponent by lazy { DaggerMoviesComponent.builder().build() }

}
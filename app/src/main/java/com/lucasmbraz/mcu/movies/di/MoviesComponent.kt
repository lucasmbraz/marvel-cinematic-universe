package com.lucasmbraz.mcu.movies.di

import com.lucasmbraz.mcu.moviedetails.MovieDetailsFragment
import com.lucasmbraz.mcu.movies.MoviesFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class])
interface MoviesComponent {
    fun inject(fragment: MoviesFragment)
    fun inject(fragment: MovieDetailsFragment)
}
package com.lucasmbraz.mcu.di

import com.lucasmbraz.mcu.moviedetails.MovieDetailsFragment
import com.lucasmbraz.mcu.movies.MoviesFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class])
interface AppComponent {
    fun inject(fragment: MoviesFragment)
    fun inject(fragment: MovieDetailsFragment)
}
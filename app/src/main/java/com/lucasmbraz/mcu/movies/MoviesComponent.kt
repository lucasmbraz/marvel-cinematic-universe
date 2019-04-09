package com.lucasmbraz.mcu.movies

import dagger.Component

@Component
interface MoviesComponent {

    fun inject(fragment: MoviesFragment)

}
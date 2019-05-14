package com.lucasmbraz.mcu.di

import com.lucasmbraz.mcu.MainActivity
import com.lucasmbraz.mcu.movies.MoviesFragment
import dagger.Subcomponent

@Subcomponent(modules = [PageChangerModule::class])
interface ActivityComponent {
    fun inject(activity: MainActivity)

    fun inject(fragment: MoviesFragment)
}
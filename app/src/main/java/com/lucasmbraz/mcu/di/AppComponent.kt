package com.lucasmbraz.mcu.di

import com.lucasmbraz.mcu.moviedetails.MovieDetailsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class])
interface AppComponent {
    fun plus(pageChangerModule: PageChangerModule): ActivityComponent

    fun inject(fragment: MovieDetailsFragment)
}
package com.lucasmbraz.mcu.movies.di

import com.lucasmbraz.mcu.api.MoviesApi
import dagger.Module
import dagger.Provides

@Module
class ApiModule {

    @Provides fun api() = MoviesApi()
}
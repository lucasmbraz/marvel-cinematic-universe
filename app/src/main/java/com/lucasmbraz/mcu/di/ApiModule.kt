package com.lucasmbraz.mcu.di

import com.lucasmbraz.mcu.api.MoviesApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides @Singleton fun api() = MoviesApi()
}
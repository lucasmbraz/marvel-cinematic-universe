package com.lucasmbraz.mcu.api

import com.lucasmbraz.mcu.model.Movie
import com.lucasmbraz.mcu.model.movies
import io.reactivex.Single
import java.util.concurrent.TimeUnit.SECONDS

// Pretend this is an external class and you
// cannot annotate the constructor with @Inject
class MoviesApi {
    fun getMovies(): Single<List<Movie>> = Single.just(movies).delay(1, SECONDS)
}
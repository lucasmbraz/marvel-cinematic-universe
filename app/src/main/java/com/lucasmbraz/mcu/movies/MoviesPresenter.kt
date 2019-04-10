package com.lucasmbraz.mcu.movies

import com.lucasmbraz.mcu.api.MoviesApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MoviesPresenter @Inject constructor(private val api: MoviesApi) {
    private lateinit var disposable: Disposable

    fun start(view: MoviesView) {
        disposable = api.getMovies()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(view::showMovies)
    }

    fun stop() {
        disposable.dispose()
    }
}
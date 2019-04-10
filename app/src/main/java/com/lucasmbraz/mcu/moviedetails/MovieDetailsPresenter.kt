package com.lucasmbraz.mcu.moviedetails

import com.lucasmbraz.mcu.api.MoviesApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MovieDetailsPresenter @Inject constructor(private val api: MoviesApi) {
    private lateinit var disposable: Disposable

    fun start(view: MovieDetailsView, movieId: String) {
        disposable = api.getMovie(movieId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(view::showMovie)
    }

    fun stop() {
        disposable.dispose()
    }
}
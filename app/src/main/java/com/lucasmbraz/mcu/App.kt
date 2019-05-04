package com.lucasmbraz.mcu

import android.app.Application
import com.lucasmbraz.mcu.di.AppComponent
import com.lucasmbraz.mcu.di.DaggerAppComponent

class App : Application() {

    val component: AppComponent by lazy { DaggerAppComponent.builder().build() }

}
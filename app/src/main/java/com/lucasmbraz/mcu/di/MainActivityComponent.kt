package com.lucasmbraz.mcu.di

import com.lucasmbraz.mcu.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [PageChangerModule::class])
interface MainActivityComponent {
    fun inject(activity: MainActivity)
}
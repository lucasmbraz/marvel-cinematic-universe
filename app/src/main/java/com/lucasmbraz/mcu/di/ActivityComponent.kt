package com.lucasmbraz.mcu.di

import com.lucasmbraz.mcu.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [PageChangerModule::class])
interface ActivityComponent {
    fun inject(activity: MainActivity)
}
package com.lucasmbraz.mcu.di

import androidx.fragment.app.FragmentManager
import com.lucasmbraz.mcu.PageChanger
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PageChangerModule(private val fragmentManager: FragmentManager) {

    @Provides @Singleton
    fun pageChanger() = PageChanger(fragmentManager)
}
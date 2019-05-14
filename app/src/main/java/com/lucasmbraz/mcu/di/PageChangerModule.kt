package com.lucasmbraz.mcu.di

import androidx.fragment.app.FragmentManager
import com.lucasmbraz.mcu.PageChanger
import dagger.Module
import dagger.Provides

@Module
class PageChangerModule(private val fragmentManager: FragmentManager) {

    @Provides
    fun pageChanger() = PageChanger(fragmentManager)
}
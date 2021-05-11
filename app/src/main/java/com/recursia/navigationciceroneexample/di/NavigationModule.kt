package com.recursia.navigationciceroneexample.di

import com.github.terrakok.cicerone.Cicerone
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object NavigationModule {

    private val cicerone = Cicerone.create()

    @Provides
    fun provideRouter() = cicerone.router

    @Provides
    fun provideNavigationHolder() = cicerone.getNavigatorHolder()
}
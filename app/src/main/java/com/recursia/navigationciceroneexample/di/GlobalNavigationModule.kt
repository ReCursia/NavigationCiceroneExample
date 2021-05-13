package com.recursia.navigationciceroneexample.di

import com.github.terrakok.cicerone.Cicerone
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class GlobalNavigationModule {

    private val cicerone = Cicerone.create()

    @Provides
    fun provideRouter() = cicerone.router

    @Provides
    fun provideNavigationHolder() = cicerone.getNavigatorHolder()
}
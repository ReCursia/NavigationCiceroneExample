package com.recursia.navigation.di

import com.github.terrakok.cicerone.Cicerone
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class GlobalNavigationModule {

    private val cicerone = Cicerone.create()

    @Provides
    @ActivityScoped
    fun provideRouter() = cicerone.router

    @Provides
    @ActivityScoped
    fun provideNavigationHolder() = cicerone.getNavigatorHolder()
}
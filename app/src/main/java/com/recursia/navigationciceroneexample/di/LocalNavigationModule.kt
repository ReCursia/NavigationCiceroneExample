package com.recursia.navigationciceroneexample.di

import com.recursia.navigationciceroneexample.common.LocalCiceroneHolder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object LocalNavigationModule {

    private val localCiceroneHolder: LocalCiceroneHolder = LocalCiceroneHolder()

    @Provides
    fun provideLocalCiceroneHolder(): LocalCiceroneHolder = localCiceroneHolder
}
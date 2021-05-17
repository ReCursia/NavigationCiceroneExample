package com.recursia.navigationciceroneexample.di

import com.recursia.navigationciceroneexample.common.LocalCiceroneHolder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class LocalNavigationModule {

    private val localCiceroneHolder: LocalCiceroneHolder = LocalCiceroneHolder()

    @Provides
    @ActivityScoped
    fun provideLocalCiceroneHolder(): LocalCiceroneHolder = localCiceroneHolder
}
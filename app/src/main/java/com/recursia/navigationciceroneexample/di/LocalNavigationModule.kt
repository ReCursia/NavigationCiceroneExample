package com.recursia.navigationciceroneexample.di

import com.recursia.navigationciceroneexample.common.LocalCiceroneHolder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class LocalNavigationModule {

    private val localCiceroneHolder: LocalCiceroneHolder = LocalCiceroneHolder()

    @Provides
    fun provideLocalCiceroneHolder(): LocalCiceroneHolder = localCiceroneHolder
}
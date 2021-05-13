package com.recursia.navigationciceroneexample.di

import android.content.Context
import com.recursia.navigationciceroneexample.TheApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ContextModule {

    @Provides
    fun provideContext(): Context = TheApplication.instance.applicationContext
}
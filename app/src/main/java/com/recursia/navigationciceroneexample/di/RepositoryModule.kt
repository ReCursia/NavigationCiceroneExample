package com.recursia.navigationciceroneexample.di

import com.recursia.navigationciceroneexample.data.WelcomeRepositoryImpl
import com.recursia.navigationciceroneexample.domain.WelcomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindWelcomeRepository(
        welcomeRepositoryImpl: WelcomeRepositoryImpl
    ): WelcomeRepository
}
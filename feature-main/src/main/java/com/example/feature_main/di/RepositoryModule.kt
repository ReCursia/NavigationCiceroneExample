package com.example.feature_main.di

import com.example.feature_main.data.WelcomeRepositoryImpl
import com.example.feature_main.domain.WelcomeRepository
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
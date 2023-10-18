package com.towhid.musicplayer.di

import com.towhid.musicplayer.utils.AppDispatcher
import com.towhid.musicplayer.utils.Dispatcher
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CoroutineModule {

    @Singleton
    @Binds
    abstract fun bindsCoroutineDispatcher(
        appCoroutineDispatcher: AppDispatcher
    ): Dispatcher
}
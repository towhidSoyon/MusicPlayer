package com.towhid.musicplayer.di

import com.towhid.musicplayer.data.remote.dataSource.lyrics.LyricDataSource
import com.towhid.musicplayer.data.remote.dataSource.lyrics.LyricsDataSourceImpl
import com.towhid.musicplayer.data.remote.dataSource.music.FirebaseMusicDataSource
import com.towhid.musicplayer.data.remote.dataSource.music.MusicDataSource
import com.towhid.musicplayer.data.repo.lyrics.LyricsRepo
import com.towhid.musicplayer.data.repo.lyrics.LyricsRepoImpl
import com.towhid.musicplayer.data.repo.music.MusicRepo
import com.towhid.musicplayer.data.repo.music.MusicRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class InterfaceModule {

    @Binds
    abstract fun bindsMusicDataSource(
        musicDataSourceImpl: FirebaseMusicDataSource
    ): MusicDataSource

    @Binds
    abstract fun bindsMusicRepo(
        musicRepoImpl: MusicRepoImpl
    ): MusicRepo

    @Binds
    abstract fun bindsLyricDataSource(
        lyricsDataSourceImpl: LyricsDataSourceImpl
    ): LyricDataSource

    @Singleton
    @Binds
    abstract fun bindsLyricsRepo(
        lyricsRepoImpl: LyricsRepoImpl
    ): LyricsRepo
}
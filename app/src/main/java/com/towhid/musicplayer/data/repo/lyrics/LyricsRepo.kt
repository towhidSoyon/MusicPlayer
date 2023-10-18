package com.towhid.musicplayer.data.repo.lyrics

import com.towhid.musicplayer.data.models.local.Lyric
import com.towhid.musicplayer.data.models.local.Music
import com.towhid.musicplayer.utils.Resource
import kotlinx.coroutines.flow.Flow

interface LyricsRepo {

    suspend fun getLyric(song: Music): Flow<Resource<Lyric>>
}
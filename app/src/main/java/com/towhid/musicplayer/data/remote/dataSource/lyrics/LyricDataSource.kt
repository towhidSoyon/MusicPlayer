package com.towhid.musicplayer.data.remote.dataSource.lyrics

import com.towhid.musicplayer.data.models.remote.lyrics.LyricsResponse
import com.towhid.musicplayer.utils.Resource

interface LyricDataSource {

    suspend fun getLyrics(query: String): Resource<LyricsResponse>
}
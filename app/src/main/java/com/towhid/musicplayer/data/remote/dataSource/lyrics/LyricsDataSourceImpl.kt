package com.towhid.musicplayer.data.remote.dataSource.lyrics

import com.towhid.musicplayer.data.models.remote.lyrics.LyricsResponse
import com.towhid.musicplayer.data.remote.retrofit.LyricsApi
import com.towhid.musicplayer.utils.Resource
import com.towhid.musicplayer.utils.safeApiCall
import javax.inject.Inject

class LyricsDataSourceImpl @Inject constructor(private val api: LyricsApi) : LyricDataSource {
    override suspend fun getLyrics(query: String): Resource<LyricsResponse> = safeApiCall {
        api.getLyrics(query)
    }
}
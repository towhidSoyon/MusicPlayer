package com.towhid.musicplayer.data.repo.music

import com.towhid.musicplayer.data.models.local.Music
import com.towhid.musicplayer.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MusicRepo {

    fun getAllSongsFlow(query: String = ""): Flow<List<Music>>

    suspend fun getAllSongs(): List<Music>

    suspend fun getSongById(id: String): Music

    suspend fun insertSongs(songs: List<Music>)

    suspend fun uploadSong(music: Music): Flow<Resource<Unit>>

    suspend fun deleteSong(song: Music)

    suspend fun deleteAllSongs()

    suspend fun fetchAllMusic(): Flow<Resource<Unit>>

    suspend fun cacheMusic(songs: List<Music>)
}
package com.towhid.musicplayer.data.local.dataSource

import com.towhid.musicplayer.data.local.room.MusicDao
import com.towhid.musicplayer.data.models.local.Music
import javax.inject.Inject

class RoomMusicDataSource @Inject constructor(private val musicDao: MusicDao) {

    fun getAllSongsFlow(query: String = "") = musicDao.getAllSongsFlow(query)

    suspend fun getAllSongs() = musicDao.getAllSongs()

    suspend fun getSongById(id: String) = musicDao.getSongById(id)

    suspend fun insertSong(songs: List<Music>) = musicDao.insertSong(songs)

    suspend fun deleteAllSongs() = musicDao.deleteAllSongs()

    suspend fun deleteSong(song: Music) = musicDao.deleteAllSongs(song)
}
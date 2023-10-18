package com.towhid.musicplayer.exoplayer.datasource

import com.towhid.musicplayer.data.local.room.MusicDao
import com.towhid.musicplayer.data.models.mapper.MusicMapper
import com.towhid.musicplayer.data.remote.dataSource.music.MusicDataSource
import com.towhid.musicplayer.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FirebaseMusicPlayerDataSource @Inject constructor(
    private val dataSource: MusicDataSource,
    private val musicMapper: MusicMapper,
    private val musicDao: MusicDao
) : MusicPlayerDataSource() {

    override suspend fun getMusic() = withContext(Dispatchers.IO) {
        state = State.STATE_INITIALIZING
        val musicResource = dataSource.getAllMusic()
        val musicDTOList = if (musicResource is Resource.Success) {
            musicResource.data ?: emptyList()
        } else emptyList()
        allMusic = musicMapper.toDomainList(musicDTOList)
        musicDao.insertSong(allMusic)
        state = State.STATE_INITIALIZED
    }
}
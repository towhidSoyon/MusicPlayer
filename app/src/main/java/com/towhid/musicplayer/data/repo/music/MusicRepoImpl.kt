package com.towhid.musicplayer.data.repo.music

import com.towhid.musicplayer.data.local.dataSource.RoomMusicDataSource
import com.towhid.musicplayer.data.models.local.Music
import com.towhid.musicplayer.data.models.mapper.MusicMapper
import com.towhid.musicplayer.data.remote.dataSource.music.MusicDataSource
import com.towhid.musicplayer.utils.Resource
import com.towhid.musicplayer.utils.mapToUnit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MusicRepoImpl @Inject constructor(
    private val musicDataSource: MusicDataSource,
    private val musicDb: RoomMusicDataSource,
    private val musicMapper: MusicMapper
) : MusicRepo {

    override fun getAllSongsFlow(query: String) = musicDb.getAllSongsFlow(query)

    override suspend fun fetchAllMusic(): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())
        val musicResource = musicDataSource.getAllMusic()
        if (musicResource is Resource.Success)
            musicResource.data?.let { cacheMusic(musicMapper.toDomainList(it)) }
        emit(musicResource.mapToUnit())
    }

    override suspend fun uploadSong(music: Music): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())
        val musicResource = musicDataSource.uploadMusic(musicMapper.toNetwork(music))
        emit(musicResource)
    }

    override suspend fun getAllSongs() = musicDb.getAllSongs()

    override suspend fun insertSongs(songs: List<Music>) = musicDb.insertSong(songs)

    override suspend fun deleteSong(song: Music) = musicDb.deleteSong(song)

    override suspend fun deleteAllSongs() = musicDb.deleteAllSongs()

    override suspend fun getSongById(id: String) = musicDb.getSongById(id)

    override suspend fun cacheMusic(songs: List<Music>) {
        deleteAllSongs()
        insertSongs(songs)
    }
}
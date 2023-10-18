package com.towhid.musicplayer.data.remote.dataSource.music

import com.towhid.musicplayer.data.models.remote.MusicDTO
import com.towhid.musicplayer.utils.Resource

interface MusicDataSource {

    suspend fun getAllMusic(): Resource<List<MusicDTO>>

    suspend fun uploadMusic(music: MusicDTO): Resource<Unit>
}
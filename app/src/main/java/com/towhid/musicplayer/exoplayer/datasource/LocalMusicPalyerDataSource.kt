package com.towhid.musicplayer.exoplayer.datasource

import android.content.Context
import com.towhid.musicplayer.utils.getLocalMusicList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject

class LocalMusicPlayerDataSource @Inject constructor(
    private val context: Context,
    private val dispatcher: Dispatcher
) : MusicPlayerDataSource() {

    override suspend fun getMusic() = withContext(Dispatchers.IO) {
        state = State.STATE_INITIALIZING
        allMusic = context.getLocalMusicList(dispatcher).first()
        state = State.STATE_INITIALIZED
    }
}
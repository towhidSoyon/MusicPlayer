package com.towhid.musicplayer.exoplayer.callbacks

import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player
import com.towhid.musicplayer.exoplayer.MusicService
import com.towhid.musicplayer.utils.showToast
import timber.log.Timber

class MediaPlayerListener constructor(private val musicService: MusicService) : Player.Listener {
    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        super.onPlayerStateChanged(playWhenReady, playbackState)
        if (playbackState == Player.STATE_READY && !playWhenReady)
            musicService.stopForeground(false)
    }

    override fun onPlayerError(error: PlaybackException) {
        super.onPlayerError(error)
        Timber.d("Player error ${error.message}")
        musicService.showToast(error.message.toString())
    }
}
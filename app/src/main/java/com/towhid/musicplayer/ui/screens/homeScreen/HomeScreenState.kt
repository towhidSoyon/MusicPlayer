package com.towhid.musicplayer.ui.screens.homeScreen

import com.towhid.musicplayer.data.models.local.Music
import com.towhid.musicplayer.utils.MusicState

data class HomeScreenState(
    val musicList: List<Music> = emptyList(),
    val currentPlayingMusic: Music? = null,
    val searchBarText: String = "",
    val musicState: MusicState = MusicState.NONE
) {
    val isMusicBottomBarVisible =
        currentPlayingMusic != null && (musicState == MusicState.PLAYING || musicState == MusicState.PAUSED)

    val isMusicPlaying = musicState == MusicState.PLAYING
}
package com.towhid.musicplayer.ui.screens.playlistscreen

import com.towhid.musicplayer.data.models.local.Music

data class PlayListScreenState(
    val currentPlayingMusic: Music? = null,
    val sliderValue: Float = 0f,
    val isPlaying: Boolean = false,
    val prevList: List<Music> = emptyList(),
    val upcomingList: List<Music> = emptyList()
)
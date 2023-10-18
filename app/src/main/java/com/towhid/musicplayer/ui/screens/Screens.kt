package com.towhid.musicplayer.ui.screens

sealed class Screens(val route: String) {

    object HomeScreen : Screens("homeScreen")
    object MusicPlayerScreen : Screens("musicPlayerScreen")
    object PlayListScreen : Screens("playlistScreen")
}
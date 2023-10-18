package com.towhid.musicplayer

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.towhid.musicplayer.ui.screens.MainViewModel
import com.towhid.musicplayer.ui.screens.Screens
import com.towhid.musicplayer.ui.screens.homeScreen.HomeScreen
import com.towhid.musicplayer.ui.screens.musicPlayer.MusicPlayerScreen
import com.towhid.musicplayer.ui.screens.playlistscreen.PlayListScreen
import com.towhid.musicplayer.ui.theme.MusicPlayerTheme
import com.towhid.musicplayer.utils.Dispatcher
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@ExperimentalCoroutinesApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity() : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    @Inject
    lateinit var dispatcher: Dispatcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

            setContent {
                MusicPlayerTheme {
                    // A surface container using the 'background' color from the theme
                    MainScreenUI()
                }
            }


    }

    private fun askForStoragePermission() {
    }

}

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@ExperimentalCoroutinesApi
@Composable
fun MainScreenUI() {
    val navController = rememberNavController()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        NavHost(navController, startDestination = Screens.HomeScreen.route) {
            composable(Screens.HomeScreen.route) {
                HomeScreen {
                    navController.navigate(Screens.MusicPlayerScreen.route)
                }
            }
            composable(Screens.MusicPlayerScreen.route) {
                MusicPlayerScreen(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    navController.navigate(Screens.PlayListScreen.route)
                }
            }
            composable(Screens.PlayListScreen.route) {
                PlayListScreen(modifier = Modifier.fillMaxSize())
            }
        }
    }
}
package com.towhid.musicplayer.ui.screens.homeScreen

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.towhid.musicplayer.R
import com.towhid.musicplayer.data.models.local.Music
import com.towhid.musicplayer.ui.components.CoilImage
import com.towhid.musicplayer.ui.components.PlayPauseButton
import com.towhid.musicplayer.ui.components.SearchBar
import com.towhid.musicplayer.ui.theme.MusicPlayerTheme
import com.towhid.musicplayer.ui.utils.BOTTOM_BAR_TAG
import com.towhid.musicplayer.utils.getArtistsString

@ExperimentalComposeUiApi
@Composable
fun MusicSearchBar(
    query: String,
    modifier : Modifier = Modifier,
    onQueryChanged: (String) -> Unit
){
    SearchBar(
        searchQuery = query,
        onSearchQueryChanged = onQueryChanged,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MusicBottomBar(
    music: Music,
    isPlaying : Boolean,
    modifier: Modifier = Modifier,
    onItemClick : (Music) -> Unit,
    onPlayPauseButtonPressed : (Music) -> Unit
){
    Surface(
        onClick = {
            onItemClick(music)
        },
        tonalElevation = 4.dp,
        shadowElevation = 4.dp,
        modifier = modifier.testTag(
            BOTTOM_BAR_TAG),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            CoilImage(
                url = music.imageUrl,
                contentDescription = "MusicPoster",
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = music.title,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Medium),
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(0.dp))
                Text(
                    text = music.artists.getArtistsString(),
                    style = MaterialTheme.typography.labelSmall,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
            PlayPauseButton(
                music = music,
                isPlaying = isPlaying,
                onPlayPauseButtonPressed = onPlayPauseButtonPressed
            )
        }
    }
}

@Composable
fun AddMusicFab(modifier: Modifier = Modifier, onClick: () -> Unit){
    LargeFloatingActionButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Rounded.Add,
            contentDescription = stringResource(R.string.add_music_cd),
            modifier = Modifier.size(40.dp))
    }
}

@Preview
@Composable
fun AddMusicFabPrevLight() {
    MusicPlayerTheme {
        AddMusicFab {
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun AddMusicFabPrevDark() {
    MusicPlayerTheme {
        AddMusicFab {
        }
    }
}

@Preview
@Composable
fun MusicBottomBarPreviewLight() {
    MusicPlayerTheme {
        MusicBottomBar(
            music = Music("", "Divide", 122131, listOf("Ed Sheeran"), "", ""),
            isPlaying = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            onItemClick = {}
        ) {
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun MusicBottomBarPreviewDark() {
    MusicPlayerTheme {
        MusicBottomBar(
            music = Music("", "Divide", 122131, listOf("Ed Sheeran"), "", ""),
            isPlaying = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            onItemClick = {}
        ) {
        }
    }
}


package com.towhid.musicplayer.data.remote.dataSource.music

import com.google.firebase.firestore.FirebaseFirestore
import com.towhid.musicplayer.data.models.remote.MusicDTO
import com.towhid.musicplayer.data.remote.util.FirestoreKeys.MUSIC_KEY
import com.towhid.musicplayer.utils.Resource
import com.towhid.musicplayer.utils.mapToUnit
import com.towhid.musicplayer.utils.safeCall
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseMusicDataSource @Inject constructor(private val fireStore: FirebaseFirestore) :
    MusicDataSource {

    override suspend fun getAllMusic(): Resource<List<MusicDTO>> = safeCall {
        fireStore.collection(MUSIC_KEY).get().await().toObjects(MusicDTO::class.java)
    }

    override suspend fun uploadMusic(music: MusicDTO) = safeCall {
        fireStore.collection(MUSIC_KEY).document(music.title).set(music).await()
    }.mapToUnit()
}
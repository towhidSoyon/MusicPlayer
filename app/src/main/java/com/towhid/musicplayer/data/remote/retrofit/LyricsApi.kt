package com.towhid.musicplayer.data.remote.retrofit

import com.towhid.musicplayer.data.models.remote.lyrics.LyricsResponse
import com.towhid.musicplayer.utils.API_KEY
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LyricsApi {

    @POST("findLyrics/")
    @FormUrlEncoded
    suspend fun getLyrics(
        @Field("q") query: String,
        @Field("api_token") apikey: String = API_KEY
    ): Response<LyricsResponse>
}
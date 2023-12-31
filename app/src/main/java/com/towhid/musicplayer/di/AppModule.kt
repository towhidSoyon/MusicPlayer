package com.towhid.musicplayer.di

import android.content.Context
import androidx.room.Room
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.towhid.musicplayer.data.local.room.MusicDao
import com.towhid.musicplayer.data.local.room.MusicXDatabase
import com.towhid.musicplayer.data.remote.retrofit.LyricsApi
import com.towhid.musicplayer.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesFirestore(): FirebaseFirestore = Firebase.firestore

    @Provides
    fun providesContext(@ApplicationContext context: Context): Context = context

//    @Provides
//    fun providesYoutubeDl(context: Context): YoutubeDL = YoutubeDL.getInstance().also {
//        it.init(context)
//    }

    @Singleton
    @Provides
    fun providesMusicDb(
        @ApplicationContext context: Context
    ): MusicXDatabase = Room.databaseBuilder(context, MusicXDatabase::class.java, "MusicXDatabase")
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun providesMusicDao(database: MusicXDatabase): MusicDao = database.getMusicDao()

    @Provides
    @Singleton
    fun providesAuthClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        ).build()

    @Provides
    @Singleton
    fun providesRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun providesLyricsApi(retrofit: Retrofit): LyricsApi = retrofit.create(LyricsApi::class.java)
}
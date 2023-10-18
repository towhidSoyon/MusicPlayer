package com.towhid.musicplayer.data.local.room

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromListOfString(list: List<String>?): String? = list?.joinToString(",")

    @TypeConverter
    fun fromStringToList(string: String?): List<String>? = string?.split(",")
}
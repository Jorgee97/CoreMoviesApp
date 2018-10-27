package com.coreman.moviesmvp.db

import android.arch.persistence.room.TypeConverter

class GenreConverter {
    @TypeConverter
    fun gettingListFromString(items: String) : List<Int> {
        val list = ArrayList<Int>()
        val array = items.split(",")
        for (i in array) {
            list.add(i.toInt())
        }
        return list
    }

    @TypeConverter
    fun writingStringFromList(list: List<Int>) : String {
        var genres = ""
        for (i in list) {
            genres += "," + i
        }
        return genres
    }
}
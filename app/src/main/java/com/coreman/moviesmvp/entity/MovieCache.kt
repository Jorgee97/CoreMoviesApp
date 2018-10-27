package com.coreman.moviesmvp.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies")
data class MovieCache (
        @PrimaryKey
        @SerializedName("id") val id: Int,
        @SerializedName("vote_average") val voteAverage: Double,
        @SerializedName("title") val title: String,
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("original_title") val originalTitle: String,
        val genres: String = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readDouble(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeDouble(voteAverage)
        parcel.writeString(title)
        parcel.writeString(posterPath)
        parcel.writeString(originalTitle)
        parcel.writeString(genres)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieCache> {
        override fun createFromParcel(parcel: Parcel): MovieCache {
            return MovieCache(parcel)
        }

        override fun newArray(size: Int): Array<MovieCache?> {
            return arrayOfNulls(size)
        }
    }
}
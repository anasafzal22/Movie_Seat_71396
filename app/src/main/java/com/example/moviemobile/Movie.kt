package com.example.moviemobile

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

class Movie : Parcelable {
    @JvmField
    val name: String?
    @JvmField
    val image: String?
    @JvmField
    val certification: String?
    @JvmField
    val description: String?
    @JvmField
    val starring: Array<String>?
    @JvmField
    val seatsRemaining: Int
    @JvmField
    val runningTime: Int

    constructor(
        name: String?,
        image: String?,
        certification: String?,
        description: String?,
        starring: Array<String>?,
        seatsRemaining: Int,
        runningTime: Int
    ) {
        this.name = name
        this.image = image
        this.certification = certification
        this.description = description
        this.starring = starring
        this.seatsRemaining = seatsRemaining
        this.runningTime = runningTime
    }

    protected constructor(`in`: Parcel) {
        name = `in`.readString()
        image = `in`.readString()
        certification = `in`.readString()
        description = `in`.readString()
        starring = `in`.createStringArray()
        seatsRemaining = `in`.readInt()
        runningTime = `in`.readInt()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(image)
        dest.writeString(certification)
        dest.writeString(description)
        dest.writeStringArray(starring)
        dest.writeInt(seatsRemaining)
        dest.writeInt(runningTime)
    }

    companion object {
        @JvmField
        val CREATOR: Creator<Movie?> = object : Creator<Movie?> {
            override fun createFromParcel(`in`: Parcel): Movie? {
                return Movie(`in`)
            }

            override fun newArray(size: Int): Array<Movie?> {
                return arrayOfNulls(size)
            }
        }
    }
}

package com.ozi.ukm

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize


@SuppressLint("ParcelCreator")
@VersionedParcelize
data class ikon (

    var desc: String? = "",
    var harga: Double?


) : Parcelable

{
//    constructor(parcel: Parcel) : this(parcel.readString()) {
//    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(desc)
    }

    override fun describeContents(): Int {
        return 0
    }

//    companion object CREATOR : Parcelable.Creator<ikon> {
//        override fun createFromParcel(parcel: Parcel): ikon {
//            return ikon(parcel)
//        }

//        override fun newArray(size: Int): Array<ikon?> {
//            return arrayOfNulls(size)
//        }
//    }
}
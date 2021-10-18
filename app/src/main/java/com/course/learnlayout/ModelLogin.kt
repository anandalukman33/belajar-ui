package com.course.learnlayout

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelLogin (
    var username: String,
    var password: String
) : Parcelable
package com.example.hst_smartfarm.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserModel(
    val nama : String,
    val email : String,
    val notelp : String,
    val password : String
) : Parcelable

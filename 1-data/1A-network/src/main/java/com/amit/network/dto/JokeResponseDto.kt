package com.amit.network.dto

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class JokeResponseDto(

    @Json(name = "joke")
    val joke: String?

) : Parcelable

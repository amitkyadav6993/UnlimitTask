package com.amit.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "Jokes_Table")
data class JokesEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @Json(name = "joke")
    @ColumnInfo(name = "joke")
    val joke: String? = null

) : Parcelable
package com.amit.network.api

import com.amit.network.dto.JokeResponseDto
import retrofit2.http.GET

interface JokeApiServices {

    @GET("api?format=json")
    suspend fun getLatestJoke(): JokeResponseDto

}
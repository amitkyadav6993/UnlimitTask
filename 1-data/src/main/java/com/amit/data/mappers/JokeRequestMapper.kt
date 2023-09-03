package com.amit.data.mappers

import com.amit.network.dto.JokeResponseDto
import com.amit.domain.entities.joke.JokeResponse
import com.amit.local.entity.JokesEntity

object JokeRequestMapper {
    fun map(jokeResponse: JokeResponse) = JokesEntity(
        joke = jokeResponse.joke
    )
}
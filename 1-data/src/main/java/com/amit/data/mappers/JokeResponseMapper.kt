package com.amit.data.mappers

import com.amit.network.dto.JokeResponseDto
import com.amit.domain.entities.joke.JokeResponse

object JokeResponseMapper {
    fun map(jokeResponseDto: JokeResponseDto) = JokeResponse(
        joke = jokeResponseDto.joke
    )
}
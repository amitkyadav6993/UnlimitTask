package com.amit.data.mappers

import com.amit.domain.entities.joke.JokeResponse
import com.amit.local.entity.JokesEntity

object JokeEntityMapper {
    fun map(jokesEntity: JokesEntity) = JokeResponse(
        id = jokesEntity.id,
        joke = jokesEntity.joke
    )
}
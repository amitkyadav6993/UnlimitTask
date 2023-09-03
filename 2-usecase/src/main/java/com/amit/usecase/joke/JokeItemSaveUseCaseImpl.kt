package com.amit.usecase.joke

import com.amit.domain.entities.joke.JokeResponse
import com.amit.domain.repositories.JokesRepository
import kotlinx.coroutines.flow.flow

internal class JokeItemSaveUseCaseImpl(
    private val jokesRepository: JokesRepository,
) : JokeItemSaveUseCase {

    override suspend fun execute(input: JokeResponse): Boolean {
        return jokesRepository.insertJoke(input)
    }

}
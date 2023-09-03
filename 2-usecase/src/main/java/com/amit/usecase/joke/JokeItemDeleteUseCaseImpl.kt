package com.amit.usecase.joke

import com.amit.domain.repositories.JokesRepository

internal class JokeItemDeleteUseCaseImpl(
    private val jokesRepository: JokesRepository,
) : JokeItemDeleteUseCase {

    override suspend fun execute(input: Int): Boolean {
        return jokesRepository.deleteJoke(input)
    }
}
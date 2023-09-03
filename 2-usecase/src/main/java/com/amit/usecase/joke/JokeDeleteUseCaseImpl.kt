package com.amit.usecase.joke

import com.amit.domain.repositories.JokesRepository

internal class JokeDeleteUseCaseImpl(
    private val jokesRepository: JokesRepository,
) : JokeDeleteUseCase {

    override suspend fun execute(): Boolean {
        return jokesRepository.deleteAllJokes()
    }
}
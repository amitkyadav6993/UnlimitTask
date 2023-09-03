package com.amit.usecase.joke

import com.amit.domain.Result
import com.amit.domain.entities.joke.JokeResponse
import com.amit.domain.repositories.JokesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class JokeLocalUseCaseImpl(
    private val jokesRepository: JokesRepository,
) : JokeLocalUseCase {

    override fun execute(): Flow<List<JokeResponse>> = flow {
        emit(jokesRepository.getOldJokes())
    }
}
package com.amit.usecase.joke

import com.amit.domain.repositories.JokesRepository
import kotlinx.coroutines.flow.flow

internal class JokeRemoteUseCaseImpl(
    private val jokesRepository: JokesRepository,
) : JokeRemoteUseCase {

    override fun execute(input: String) = flow {
        emit(jokesRepository.getLatestJoke())
    }

}
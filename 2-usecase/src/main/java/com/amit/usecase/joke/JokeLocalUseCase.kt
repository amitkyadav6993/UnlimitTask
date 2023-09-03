package com.amit.usecase.joke

import com.amit.domain.entities.joke.JokeResponse
import com.amit.usecase.base.UseCase
import kotlinx.coroutines.flow.Flow
import com.amit.domain.Result
import com.amit.usecase.base.NoInputUseCase

interface JokeLocalUseCase : NoInputUseCase<Flow<List<JokeResponse>>>
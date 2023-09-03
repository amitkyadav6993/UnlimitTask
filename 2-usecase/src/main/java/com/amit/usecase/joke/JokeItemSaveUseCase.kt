package com.amit.usecase.joke

import com.amit.domain.entities.joke.JokeResponse
import com.amit.usecase.base.SuspendingUseCase
import com.amit.usecase.base.UseCase

interface JokeItemSaveUseCase : SuspendingUseCase<JokeResponse, Boolean>
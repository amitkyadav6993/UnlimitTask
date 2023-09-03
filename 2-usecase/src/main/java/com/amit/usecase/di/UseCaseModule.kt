package com.amit.usecase.di

import com.amit.data.di.dataModules
import com.amit.usecase.joke.JokeDeleteUseCase
import com.amit.usecase.joke.JokeDeleteUseCaseImpl
import com.amit.usecase.joke.JokeItemDeleteUseCase
import com.amit.usecase.joke.JokeItemDeleteUseCaseImpl
import com.amit.usecase.joke.JokeItemSaveUseCase
import com.amit.usecase.joke.JokeItemSaveUseCaseImpl
import com.amit.usecase.joke.JokeLocalUseCase
import com.amit.usecase.joke.JokeLocalUseCaseImpl
import com.amit.usecase.joke.JokeRemoteUseCase
import com.amit.usecase.joke.JokeRemoteUseCaseImpl
import org.koin.dsl.module

private val useCaseModule = module {

    factory<JokeRemoteUseCase> {
        JokeRemoteUseCaseImpl(jokesRepository = get())
    }

    factory<JokeDeleteUseCase> {
        JokeDeleteUseCaseImpl(jokesRepository = get())
    }

    factory<JokeItemDeleteUseCase> {
        JokeItemDeleteUseCaseImpl(jokesRepository = get())
    }

    factory<JokeItemSaveUseCase> {
        JokeItemSaveUseCaseImpl(jokesRepository = get())
    }

    factory<JokeLocalUseCase> {
        JokeLocalUseCaseImpl(jokesRepository = get())
    }
}

val useCaseModules = useCaseModule + dataModules
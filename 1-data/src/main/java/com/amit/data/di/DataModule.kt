package com.amit.data.di

import com.amit.data.repositoriesImpl.JokeRepositoryImpl
import com.amit.local.di.localModule
import com.amit.network.di.networkModule
import com.amit.domain.repositories.JokesRepository
import org.koin.dsl.module

private val repositoriesModule = module {

    factory<JokesRepository> {
        JokeRepositoryImpl(jokeApiServices = get(),
            jokeItemDao = get())
    }
}

val dataModules = repositoriesModule + networkModule + localModule
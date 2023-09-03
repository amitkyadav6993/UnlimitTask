package com.amit.domain.repositories

import com.amit.domain.Result
import com.amit.domain.entities.joke.JokeResponse

interface JokesRepository {
    suspend fun getLatestJoke(): Result<JokeResponse>
    suspend fun insertJoke(item: JokeResponse): Boolean
    suspend fun deleteJoke(jokeId: Int): Boolean
    suspend fun deleteAllJokes(): Boolean
    suspend fun getOldJokes(): List<JokeResponse>
}
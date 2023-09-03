package com.amit.data.repositoriesImpl

import com.amit.data.mappers.JokeEntityMapper
import com.amit.data.mappers.JokeRequestMapper
import com.amit.data.mappers.JokeResponseMapper
import com.amit.domain.Result
import com.amit.domain.entities.joke.JokeResponse
import com.amit.domain.map
import com.amit.domain.repositories.JokesRepository
import com.amit.local.dao.JokeItemDao
import com.amit.network.api.JokeApiServices

internal class JokeRepositoryImpl(
    private val jokeApiServices: JokeApiServices,
    private val jokeItemDao: JokeItemDao
) : JokesRepository {

    override suspend fun getLatestJoke(): Result<JokeResponse> {
        return Result.runCatching { jokeApiServices.getLatestJoke() }.map {
            JokeResponseMapper.map(it)
        }
    }

    override suspend fun insertJoke(item: JokeResponse): Boolean{
        return jokeItemDao.insert(JokeRequestMapper.map(item)) > 0
    }

    override suspend fun deleteAllJokes(): Boolean{
        return jokeItemDao.deleteAll() > 0
    }

    override suspend fun getOldJokes(): List<JokeResponse> {
        return jokeItemDao.getAll().map { JokeEntityMapper.map(it) }
    }

    override suspend fun deleteJoke(jokeId: Int): Boolean {
        return jokeItemDao.deleteItem(jokeId) > 0
    }

}

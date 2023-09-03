package com.amit.unlimit.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amit.domain.entities.joke.JokeResponse
import com.amit.domain.fold
import com.amit.usecase.joke.JokeDeleteUseCase
import com.amit.usecase.joke.JokeItemDeleteUseCase
import com.amit.usecase.joke.JokeItemSaveUseCase
import com.amit.usecase.joke.JokeLocalUseCase
import com.amit.usecase.joke.JokeRemoteUseCase
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

class MainViewModel(
    private val jokeRemoteUseCase: JokeRemoteUseCase,
    private val jokeLocalUseCase: JokeLocalUseCase,
    private val jokeItemDeleteUseCase: JokeItemDeleteUseCase,
    private val jokeDeleteUseCase: JokeDeleteUseCase,
    private val jokeItemSaveUseCase: JokeItemSaveUseCase
) : ViewModel() {

    private val _jokes = MutableLiveData<JokesViewStateData>(JokesViewStateData.Initial)
    val jokesLiveData: LiveData<JokesViewStateData> get() = _jokes

    private val jokesList = ArrayList<JokeResponse>()

    fun fetchLocalJokes() {
        viewModelScope.launch {
            kotlin.runCatching {
                jokeLocalUseCase.execute().collect {
                    if (it.isNotEmpty()) {
                        jokesList.addAll(it)
                        _jokes.value = JokesViewStateData.Success(dataList = jokesList)
                    }
                    fetchRemoteJokes()
                }
            }.onFailure {
                jokeDeleteUseCase.execute()
                fetchRemoteJokes()
            }
        }
    }

    private fun fetchRemoteJokes() {
        viewModelScope.launch {
            jokeRemoteUseCase.execute("").collect {
                it.fold(onSuccess = { response ->
                    if (response.joke.isNullOrEmpty()) {
                        _jokes.value = JokesViewStateData.LoadFailed
                    } else {
                        saveDataInLocal(response)
                    }
                }, onFailure = { throwable ->
                    _jokes.value = JokesViewStateData.Failure(throwable)
                })
            }
        }
    }

    private fun saveDataInLocal(response: JokeResponse) {
        viewModelScope.launch {
            jokesList.apply {
                if (size >= 10) {
                    lastOrNull()?.id?.let { id -> jokeItemDeleteUseCase.execute(id) }
                    removeLast()
                }

                add(0, response)
                jokeItemSaveUseCase.execute(response)
                _jokes.value = JokesViewStateData.Success(dataList = this)

                delay(1.minutes)
                fetchRemoteJokes()
            }
        }
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }

}
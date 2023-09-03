package com.amit.unlimit.view.viewmodel

import com.amit.domain.entities.joke.JokeResponse

sealed class JokesViewStateData {
    internal data object Initial : JokesViewStateData()
    internal data object Loading : JokesViewStateData()
    internal data object LoadFailed : JokesViewStateData()
    internal data class Failure(val throwable: Throwable) : JokesViewStateData()
    internal data class Success(val dataList: ArrayList<JokeResponse>?) : JokesViewStateData()
}
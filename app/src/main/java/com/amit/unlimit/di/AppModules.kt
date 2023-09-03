package com.amit.unlimit.di

import com.amit.unlimit.BuildConfig
import com.amit.unlimit.view.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModules = module {

    single(named("base_url")) { BuildConfig.BASE_URL }

    viewModel {
        MainViewModel(
            jokeRemoteUseCase = get(),
            jokeLocalUseCase = get(),
            jokeDeleteUseCase = get(),
            jokeItemDeleteUseCase = get(),
            jokeItemSaveUseCase = get(),
        )
    }
}
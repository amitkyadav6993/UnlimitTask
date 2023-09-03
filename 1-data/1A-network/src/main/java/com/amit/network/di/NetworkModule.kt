package com.amit.network.di

import com.amit.network.api.JokeApiServices
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.UUID
import java.util.concurrent.TimeUnit

val networkModule = module {

    single { File(androidContext().cacheDir, UUID.randomUUID().toString()) }

    single { Cache(get(), 5 * 1024 * 1024) }

    single {
        OkHttpClient.Builder()
            .cache(get())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .followSslRedirects(true)
            .build()
    }

    single<Moshi> {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    single<Retrofit.Builder> {
        Retrofit.Builder()
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
    }

    single<JokeApiServices> {
        get<Retrofit.Builder>()
            .baseUrl(get<String>(named("base_url")))
            .build()
            .create(JokeApiServices::class.java)
    }
}
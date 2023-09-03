package dependencies

/**
 * Project dependencies, makes it easy to include external binaries or
 * other library modules to build.
 */

object Libraries {
    const val appcompat = "androidx.appcompat:appcompat:${BuildDependenciesVersions.appcompat}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${BuildDependenciesVersions.constraintlayout}"
    const val coreKtx = "androidx.core:core-ktx:${BuildDependenciesVersions.core}"
    const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${BuildDependenciesVersions.kotlinCoroutines}"
    const val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${BuildDependenciesVersions.lifecycle}"
    const val lifecyleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${BuildDependenciesVersions.lifecycle}"
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${BuildDependenciesVersions.moshi}"
    const val moshiAdapter = "com.squareup.moshi:moshi-adapters:${BuildDependenciesVersions.moshi}"
    const val multidex = "androidx.multidex:multidex:${BuildDependenciesVersions.multidex}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${BuildDependenciesVersions.recyclerview}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${BuildDependenciesVersions.retrofit}"
    const val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:${BuildDependenciesVersions.retrofit}"
    const val retrofitRxJava = "com.squareup.retrofit2:adapter-rxjava2:${BuildDependenciesVersions.retrofit}"
    const val roomRuntime = "androidx.room:room-runtime:${BuildDependenciesVersions.room}"
    const val roomTest = "androidx.room:room-testing:${BuildDependenciesVersions.room}"
    const val roomKtx = "androidx.room:room-ktx:${BuildDependenciesVersions.room}"
    const val viewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${BuildDependenciesVersions.lifecycle}"
    const val koinAndroid = "io.insert-koin:koin-android:${BuildDependenciesVersions.koin}"
    const val koinCompact = "io.insert-koin:koin-android-compat:${BuildDependenciesVersions.koin}"
    const val googleMaterial = "com.google.android.material:material:${BuildDependenciesVersions.materialDesign}"
    const val ktxViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${BuildDependenciesVersions.lifecycle}"
    const val serializationCore = "org.jetbrains.kotlinx:kotlinx-serialization-core:1.0.1"
    const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1"
    const val okhttp = "com.squareup.okhttp3:okhttp:${BuildDependenciesVersions.logginInterceptor}"
    const val timber = "com.jakewharton.timber:timber:5.0.1"
    const val gson = "com.google.code.gson:gson:2.8.6"
    const val startup = "androidx.startup:startup-runtime:1.0.0"
}
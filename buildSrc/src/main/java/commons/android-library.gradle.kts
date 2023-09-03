package commons

import BuildAndroidConfig
import dependencies.Libraries
import extentions.implementation

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
}

android {
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = BuildAndroidConfig.MIN_SDK_VERSION
        targetSdk = BuildAndroidConfig.TARGET_SDK_VERSION

        buildConfigField("String", "VERSION_NAME", "\"${BuildAndroidConfig.VERSION_NAME}\"")
        buildConfigField("String", "VERSION_CODE", "\"${BuildAndroidConfig.VERSION_CODE}\"")

    }

    compileOptions {
        sourceCompatibility = BuildAndroidConfig.java
        targetCompatibility = BuildAndroidConfig.java
    }

    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs = listOf(
            "-progressive",
            "-Xjvm-default=all",
            "-Xallow-result-return-type",
            "-opt-in=kotlin.RequiresOptIn",
            "-opt-in=kotlinx.serialization.ExperimentalSerializationApi",
            "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
            "-opt-in=kotlin.time.ExperimentalTime",
            "-opt-in=kotlinx.coroutines.ObsoleteCoroutinesApi",
            "-opt-in=kotlinx.coroutines.FlowPreview"
        )
    }

    buildFeatures {
        viewBinding = true
    }
}

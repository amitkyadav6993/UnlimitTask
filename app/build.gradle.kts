
import dependencies.*
import extentions.implementation

plugins {
    id("com.google.devtools.ksp")
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
}

android {

    compileSdk = 33
    buildToolsVersion = "33.0.1"

    compileOptions {
        sourceCompatibility = BuildAndroidConfig.java
        targetCompatibility = BuildAndroidConfig.java
    }

    defaultConfig {
        applicationId = BuildAndroidConfig.APPLICATION_ID
        minSdk = BuildAndroidConfig.MIN_SDK_VERSION
        targetSdk = BuildAndroidConfig.TARGET_SDK_VERSION
        multiDexEnabled = BuildAndroidConfig.MULTIDEX_ENABLED

        versionName = BuildAndroidConfig.VERSION_NAME
        versionCode = BuildAndroidConfig.VERSION_CODE

        buildConfigField("String", "BASE_URL", "\"https://geek-jokes.sameerkumar.website/\"")

    }

    dependenciesInfo {
        includeInApk = false
        includeInBundle = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        getByName(BuildType.DEBUG) {
            isDebuggable = true
            versionNameSuffix = BuildTypeDebug.versionNameSuffix
            isShrinkResources = BuildTypeDebug.isShrinkResources
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
        }

        getByName(BuildType.RELEASE) {
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            isShrinkResources = BuildTypeRelease.isShrinkResources
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            enableAndroidTestCoverage = BuildTypeRelease.isTestCoverageEnabled
        }
    }

    flavorDimensions += listOf(BuildProductDimensions.ENVIRONMENT)

    productFlavors {
        register("production") {
            buildConfigField("String", "BASE_URL", "\"https://geek-jokes.sameerkumar.website/\"")
        }
        register("staging") {
            buildConfigField("String", "BASE_URL", "\"https://geek-jokes.sameerkumar.website/\"")
        }
        register("uiTests") {
            buildConfigField("String", "BASE_URL", "\"https://geek-jokes.sameerkumar.website/\"")
        }
    }
    namespace = "com.amit.unlimit"
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar","*.so"))))

    implementation(project(ProjectDependencies.domainModule))
    implementation(project(ProjectDependencies.networkModule))
    implementation(project(ProjectDependencies.localModule))
    implementation(project(ProjectDependencies.dataModule))
    implementation(project(ProjectDependencies.usecaseModule))

    implementation(Libraries.coreKtx)
    implementation(Libraries.appcompat)
    implementation(Libraries.constraintlayout)
    implementation(Libraries.lifecycleCommon)
    implementation(Libraries.lifecyleRuntime)
    implementation(Libraries.moshiKotlin)
    implementation(Libraries.multidex)
    implementation(Libraries.recyclerview)
    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitMoshi)
    implementation(Libraries.retrofitRxJava)
    implementation(Libraries.koinAndroid)
    implementation(Libraries.koinCompact)
    implementation(Libraries.ktxViewModel)
    implementation(Libraries.viewModelSavedState)
    implementation(Libraries.constraintlayout)
    implementation(Libraries.googleMaterial)
    ksp(AnnotationProcessorsDependencies.moshi)

    implementation(Libraries.startup)

}

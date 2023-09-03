import dependencies.*
import extentions.implementation

plugins {
    id("commons.android-library")
}

dependencies {
    implementation(Libraries.coreKtx)
    implementation(Libraries.kotlinCoroutines)
    implementation(Libraries.koinAndroid)
    implementation(Libraries.koinCompact)

    api(project(ProjectDependencies.domainModule))
    api(project(ProjectDependencies.networkModule))
    api(project(ProjectDependencies.localModule))
}

android {
    namespace = "com.amit.data"
}
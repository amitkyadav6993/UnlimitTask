import dependencies.Libraries
import dependencies.ProjectDependencies
import extentions.implementation

plugins {
    id("commons.android-library")
}

dependencies {
    implementation(project(ProjectDependencies.domainModule))

    implementation(Libraries.coreKtx)
    implementation(Libraries.kotlinCoroutines)
    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitMoshi)
    implementation(Libraries.moshiKotlin)
    implementation(Libraries.koinAndroid)
    implementation(Libraries.koinCompact)
    implementation(Libraries.okhttp)

}
android {
    namespace = "com.amit.network"
}

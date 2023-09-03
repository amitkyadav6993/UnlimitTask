import dependencies.AnnotationProcessorsDependencies
import dependencies.Libraries
import dependencies.ProjectDependencies
import extentions.implementation

plugins {
    id("commons.android-library")
    id("com.google.devtools.ksp")
}

android{
    defaultConfig{
        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf(
                    "room.schemaLocation" to "$projectDir/schemas",
                    "room.incremental" to "true",
                    "room.expandProjection" to "true"
                )
            }
        }
    }
}

dependencies {
    implementation(project(ProjectDependencies.domainModule))

    implementation(Libraries.coreKtx)
    implementation(Libraries.kotlinCoroutines)
    implementation(Libraries.koinAndroid)
    implementation(Libraries.koinCompact)
    implementation(Libraries.roomRuntime)
    implementation(Libraries.roomKtx)
    ksp(AnnotationProcessorsDependencies.roomCompiler)

    api(Libraries.moshiKotlin)
    ksp(AnnotationProcessorsDependencies.moshi)

}
android {
    namespace = "com.amit.local"
}

package dependencies

/**
 * Project annotation processor dependencies, makes it easy to include external binaries or
 * other library modules to build.
 */
object AnnotationProcessorsDependencies {
    const val moshi = "com.squareup.moshi:moshi-kotlin-codegen:${BuildDependenciesVersions.moshi}"
    const val roomCompiler = "androidx.room:room-compiler:${BuildDependenciesVersions.room}"
}

package dependencies

/**
 * Project module dependencies, makes it easy to include external binaries or
 * other library modules to build.
 */
object ProjectDependencies {
    const val domainModule = ":0-domain"
    const val dataModule = ":1-data"
    const val networkModule = ":1-data:1A-network"
    const val localModule = ":1-data:1B-local"
    const val usecaseModule = ":2-usecase"
}
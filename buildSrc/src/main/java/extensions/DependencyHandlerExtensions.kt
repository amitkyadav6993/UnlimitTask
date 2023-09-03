package extentions

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * Adds a dependency to the `implementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.implementation(dependencyNotation: String): Dependency? =
    add("implementation", dependencyNotation)

/**
 * Adds a dependency to the `api` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.api(dependencyNotation: String): Dependency? =
    add("api", dependencyNotation)

/**
 * Adds a dependency to the `kapt` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.kapt(dependencyNotation: String): Dependency? =
    add("kapt", dependencyNotation)

/**
 * Adds a dependency to the `testImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.testImplementation(dependencyNotation: String): Dependency? =
    add("testImplementation", dependencyNotation)


/**
 * Adds all the tests dependencies to specific configuration.
 */
fun DependencyHandler.addTestsDependencies() {
//    testImplementation(TestDependencies.JUNIT)
//    testImplementation(TestDependencies.MOCKK)
//    testImplementation(TestDependencies.ASSERTJ)
//    testImplementation(TestDependencies.ROBOELECTRIC)
//    testImplementation(TestDependencies.ROOM)
//    testImplementation(TestDependencies.CORE)
//    testImplementation(TestDependencies.ARCH_CORE)
//    testImplementation(TestDependencies.RULES)
//    testImplementation(TestDependencies.RUNNER)
//    testImplementation(TestDependencies.COROUTINES_TEST)
//    testImplementation(TestDependencies.FRAGMENT_TEST)
//    testImplementation(TestDependencies.EXT)
//    testImplementation(TestDependencies.MOCK_WEB_SERVER)
//
//    androidTestImplementation(TestAndroidDependencies.PLAY_CORE)
//    androidTestImplementation(TestAndroidDependencies.LEAKCANARY)
//    androidTestImplementation(TestAndroidDependencies.ESPRESSO)
//    androidTestImplementation(TestAndroidDependencies.RUNNER)
//    androidTestImplementation(TestAndroidDependencies.RULES)
//    androidTestImplementation(TestAndroidDependencies.JUNIT)
//    androidTestImplementation(TestAndroidDependencies.FRAGMENT_TEST)
}

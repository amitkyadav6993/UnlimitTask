import org.gradle.api.JavaVersion

object BuildAndroidConfig {
    const val APPLICATION_ID = "com.amit.unlimit"

    const val BUILD_TOOLS_VERSION = "33.0.1"
    const val COMPILE_SDK_VERSION = 33
    const val MIN_SDK_VERSION = 21
    const val TARGET_SDK_VERSION = 33

    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0.0"

    const val MULTIDEX_ENABLED = true

    val java = JavaVersion.VERSION_17
}

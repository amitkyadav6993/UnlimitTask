repositories {
    google()
    maven(url = "https://plugins.gradle.org/m2/")
    mavenCentral()
}

plugins {
    java
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}


dependencies {
    implementation(gradleApi())
    implementation("com.android.tools.build:gradle:8.1.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10")
    implementation("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:1.9.10-1.0.13")
}

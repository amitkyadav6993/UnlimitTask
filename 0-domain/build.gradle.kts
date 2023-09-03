import dependencies.Libraries
import extentions.implementation

plugins {
    id("commons.android-library")
}

dependencies {
    implementation(Libraries.coreKtx)
    implementation(Libraries.kotlinCoroutines)

}
//namespace is deprecated in manifest so added here
android {
    namespace = "com.amit.domain"
}
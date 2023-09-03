import extentions.applyDefault

allprojects {
    repositories.applyDefault()
    repositories {
        maven(File(rootDir, "libs"))
    }
}



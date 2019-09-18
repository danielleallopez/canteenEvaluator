plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Sdk.compileVersion)
    buildToolsVersion(Core.buildToolsVersion)
    defaultConfig {
        minSdkVersion(Sdk.minVersion)

        buildConfigField("int", "DATABASE_VERSION", "1")
    }
}

dependencies {
    implementation(project(":core"))

    //Room
    kapt(Room.compiler)
}
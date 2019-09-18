plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(Sdk.compileVersion)
    buildToolsVersion(Core.buildToolsVersion)
    defaultConfig {
        minSdkVersion(Sdk.minVersion)
        testInstrumentationRunner = Testing.androidTestRunner
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":data"))

    implementation(AndroidX.core)
    implementation(AndroidX.material)
    implementation(AndroidX.constraintLayout)

    implementation(Koin.viewmodel)
}

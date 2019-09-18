plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdkVersion(Sdk.compileVersion)
    buildToolsVersion(Core.buildToolsVersion)
    defaultConfig {
        minSdkVersion(Sdk.minVersion)
        targetSdkVersion(Sdk.targetVersion)
        versionCode = Version.code
        versionName = Version.name
    }

    buildTypes {

        getByName("release") {
            buildConfigField("boolean", "FABRIC_ENABLED", "true")
        }

        getByName("debug") {
            buildConfigField("boolean", "FABRIC_ENABLED", "false")
        }
    }
}

dependencies {
    implementation(Core.kotlin_stdlib)
    implementation(AndroidX.appcompat)
    implementation(AndroidX.core)
    implementation(AndroidX.constraintLayout)
    implementation(AndroidX.recyclerView)
    implementation(AndroidX.lifecycleExtensions)
    implementation(AndroidX.material)

    // Navigation
    implementation(AndroidX.navigation_fragment)
    implementation(AndroidX.navigation_ui)

    //Rx
    api(Rx.java)
    api(Rx.android)
    api(Rx.kotlin)

    //Room
    api(Room.runtime)
    api(Room.rxjava2)

    //Fabric
    api(Fabric.crashlytics) {
        isTransitive = true
    }
    api(Fabric.firebaseCore)

    //Koin
    api(Koin.android)
    implementation(Koin.viewmodel)

    //Testing
    testApi(Testing.junit)
    androidTestApi(Testing.testRunner)
    androidTestApi(Testing.espressoCore)
}

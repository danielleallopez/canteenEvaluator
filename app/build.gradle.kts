plugins {
    id("com.android.application")
    id("io.fabric")
    id("kotlin-android")
    id("kotlin-android-extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Sdk.compileVersion)
    buildToolsVersion(Core.buildToolsVersion)
    defaultConfig {
        applicationId = "com.dleal.canteenevaluator"
        minSdkVersion(Sdk.minVersion)
        targetSdkVersion(Sdk.targetVersion)
        versionCode = Version.code
        versionName = Version.name
        testInstrumentationRunner = Testing.androidTestRunner

        vectorDrawables.useSupportLibrary = true

        javaCompileOptions {
            annotationProcessorOptions {
                arguments(
                    mapOf(
                        "room.schemaLocation" to "$projectDir/schemas"
                    )
                )
            }
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":data"))
    implementation(project(":student"))

    implementation(AndroidX.core)
    implementation(AndroidX.material)

    implementation(Koin.viewmodel)
    testImplementation(Koin.testing)

    implementation(AndroidX.navigation_fragment)
    implementation(AndroidX.navigation_ui)
}

apply(plugin = "com.google.gms.google-services")
object Sdk {
    const val minVersion = 16
    const val targetVersion = 28
    const val compileVersion = 28
}

object Version {
    const val code = 1
    const val name = "1.0.0"
}

object Kotlin {
    private const val version = "1.3.31"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
}

object AndroidX {
    private const val supportLibVersion = "1.1.0-alpha07"
    const val core = "androidx.core:core-ktx:1.2.0-alpha02"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.0-beta1"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:2.2.0-alpha01"
    const val appcompat = "androidx.appcompat:appcompat:1.1.0-beta01"
    const val material = "com.google.android.material:material:$supportLibVersion"
    const val recyclerView = "androidx.recyclerview:recyclerview:$supportLibVersion"

    // Navigation
    private const val nav_version = "1.0.0"
    const val navigation_fragment = "android.arch.navigation:navigation-fragment-ktx:$nav_version"
    const val navigation_ui = "android.arch.navigation:navigation-ui-ktx:$nav_version"
}

object Room {
    private const val room_version = "2.1.0"
    val runtime = "androidx.room:room-runtime:$room_version"
    val compiler = "androidx.room:room-compiler:$room_version"
    val rxjava2 = "androidx.room:room-rxjava2:$room_version"
}

object Rx {
    private const val rxJavaVersion = "2.1.10"
    private const val rxAndroidVersion = "2.1.0"
    private const val rxKotlin = "2.2.0"
    val java = "io.reactivex.rxjava2:rxjava:$rxJavaVersion"
    val android = "io.reactivex.rxjava2:rxandroid:$rxAndroidVersion"
    val kotlin = "io.reactivex.rxjava2:rxkotlin:$rxKotlin"
}

object Fabric {
    const val crashlytics = "com.crashlytics.sdk.android:crashlytics:2.10.1@aar"
    const val firebaseCore = "com.google.firebase:firebase-core:17.0.0"
}

object Testing {
    const val androidTestRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val junit = "junit:junit:4.13-beta-3"
    const val testRunner = "androidx.test:runner:1.2.0"
    const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
}

object Koin {
    private const val version = "2.0.1"
    const val core = "org.koin:koin-core:$version"
    const val android = "org.koin:koin-android:$version"
    const val scope = "org.koin:koin-androidx-scope:$version"
    const val viewmodel = "org.koin:koin-androidx-viewmodel:$version"
    const val testing = "org.koin:koin-test:$version"
}
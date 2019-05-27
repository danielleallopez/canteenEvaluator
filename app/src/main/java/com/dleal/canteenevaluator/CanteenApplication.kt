package com.dleal.canteenevaluator

import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.fabric.sdk.android.Fabric
import javax.inject.Inject

class CanteenApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = androidInjector

    @Inject
    lateinit var androidInjector: AndroidInjector<DaggerApplication>

//    private val canteenComponent: AppComponent by lazy {
//        DaggerAppComponent
//            .builder()
//            .application(this)
//            .build()
//    }

    override fun onCreate() {
        super.onCreate()

        initFabric()

//        canteenComponent.inject(this)
    }

    private fun initFabric() {
        val crashlyticsCore = CrashlyticsCore.Builder()
            .disabled(false)
            .build()
        val crashlytics = Crashlytics.Builder()
            .core(crashlyticsCore)
            .build()
        Fabric.with(applicationContext, crashlytics)
    }
}
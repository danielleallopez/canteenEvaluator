package com.dleal.canteenevaluator

import android.app.Activity
import android.app.Application
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import com.dleal.canteenevaluator.di.AppComponent
import com.dleal.canteenevaluator.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.fabric.sdk.android.Fabric
import javax.inject.Inject

class CanteenApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector

    private val canteenComponent: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        initFabric()

        canteenComponent.inject(this)
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
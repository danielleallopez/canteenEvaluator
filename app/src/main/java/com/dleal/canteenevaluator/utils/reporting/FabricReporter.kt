package com.dleal.canteenevaluator.utils.reporting

import android.content.Context
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import com.dleal.canteenevaluator.BuildConfig
import io.fabric.sdk.android.Fabric

class FabricReporter(private val context: Context) : Reporter {

    override fun initFabric(enableCrashlytics: Boolean) {
        val crashlytics = Crashlytics.Builder()
            .core(CrashlyticsCore.Builder().disabled(!enableCrashlytics).build())
            .build()
        Fabric.with(context, crashlytics)
    }

    fun log(message: String) {
        if (BuildConfig.FABRIC_ENABLED) {
            Crashlytics.log(message)
        }
    }

    override fun logException(throwable: Throwable) {
        if (BuildConfig.FABRIC_ENABLED) {
            Crashlytics.logException(throwable)
        }
    }
}
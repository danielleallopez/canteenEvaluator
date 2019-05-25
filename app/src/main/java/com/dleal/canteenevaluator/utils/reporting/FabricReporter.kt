package com.dleal.canteenevaluator.utils.reporting

import android.content.Context
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import io.fabric.sdk.android.Fabric

class FabricReporter(private val fabricConfig: FabricConfig) : Reporter(fabricConfig) {

    init {
        val crashlytics = Crashlytics.Builder()
            .core(CrashlyticsCore.Builder().disabled(!fabricConfig.reportingEnabled).build())
            .build()
        Fabric.with(fabricConfig.context, crashlytics)
    }

    override fun log(message: String) {
        if (fabricConfig.reportingEnabled) {
            Crashlytics.log(message)
        }
    }

    override fun logException(throwable: Throwable) {
        if (fabricConfig.reportingEnabled) {
            Crashlytics.logException(throwable)
        }
    }
}

class FabricConfig(val context: Context, reportingEnabled: Boolean) : ReporterConfig(reportingEnabled)
package com.dleal.core.utils.reporting

import android.content.Context
import com.crashlytics.android.Crashlytics

class FabricReporter(private val fabricConfig: FabricConfig) : Reporter(fabricConfig) {

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
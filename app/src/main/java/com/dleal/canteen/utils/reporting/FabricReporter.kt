package com.dleal.canteen.utils.reporting

import com.crashlytics.android.Crashlytics
import com.dleal.canteen.BuildConfig
import javax.inject.Inject

/**
 * Created by Daniel Leal on 25/2/18.
 */
class FabricReporter @Inject constructor(reporterConfig: ReporterConfig) : Reporter(reporterConfig) {

    override fun log(message: String) {
        if (reporterConfig.reportingEnabled) {
            Crashlytics.log(message)
        }
    }

    override fun logException(throwable: Throwable) {
        if (reporterConfig.reportingEnabled) {
            Crashlytics.logException(throwable)
        }
    }
}
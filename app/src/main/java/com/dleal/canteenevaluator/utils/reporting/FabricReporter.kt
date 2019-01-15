package com.dleal.canteenevaluator.utils.reporting

import com.crashlytics.android.Crashlytics
import com.dleal.canteenevaluator.BuildConfig
import javax.inject.Inject

/**
 * Created by Daniel Leal on 25/2/18.
 */
class FabricReporter @Inject constructor() {

    fun log(message: String) {
        if (BuildConfig.FABRIC_ENABLED) {
            Crashlytics.log(message)
        }
    }

    fun logException(throwable: Throwable) {
        if (BuildConfig.FABRIC_ENABLED) {
            Crashlytics.logException(throwable)
        }
    }
}
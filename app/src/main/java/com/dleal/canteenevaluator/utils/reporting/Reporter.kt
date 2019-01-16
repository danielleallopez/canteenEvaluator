package com.dleal.canteenevaluator.utils.reporting

import com.dleal.canteenevaluator.BuildConfig

interface Reporter {

    /**
     * Initializes Fabric.
     *
     * @param enableCrashlytics should always be `false` for debug builds.
     */
    fun initFabric(enableCrashlytics: Boolean = !BuildConfig.DEBUG)
}
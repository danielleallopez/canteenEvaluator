package com.dleal.canteen.utils.reporting

/**
 * Created by Daniel Leal on 2019-05-25.
 */
abstract class Reporter(val reporterConfig: ReporterConfig) {
    abstract fun log(message: String)
    abstract fun logException(throwable: Throwable)
}

abstract class ReporterConfig(
        val reportingEnabled: Boolean
)
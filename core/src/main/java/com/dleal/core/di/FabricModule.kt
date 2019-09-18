package com.dleal.core.di

import com.dleal.core.BuildConfig
import com.dleal.core.utils.reporting.FabricConfig
import com.dleal.core.utils.reporting.FabricReporter
import com.dleal.core.utils.reporting.Reporter
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by Daniel Leal on 2019-06-16.
 */
val fabricModule = module {
    single(named(FABRIC_ENABLED)) { BuildConfig.FABRIC_ENABLED }
    single { FabricConfig(androidContext(), get(named(FABRIC_ENABLED))) }
    single<Reporter> { FabricReporter(get()) }
}

private const val FABRIC_ENABLED = "fabricEnabled"
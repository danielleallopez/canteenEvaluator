package com.dleal.canteenevaluator.di

import android.content.Context
import com.dleal.canteenevaluator.BuildConfig
import com.dleal.canteenevaluator.CanteenApplication
import com.dleal.core.utils.reporting.FabricConfig
import com.dleal.core.utils.reporting.FabricReporter
import com.dleal.core.utils.reporting.Reporter
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(consumerApp: CanteenApplication): Context = consumerApp.applicationContext

    @Provides
    @Singleton
    @Named(FABRIC_ENABLED)
    fun provideFabricEnabled() = BuildConfig.FABRIC_ENABLED

    @Provides
    @Singleton
    fun provideFabricConfig(
        @Named(FABRIC_ENABLED) fabricEnabled: Boolean,
        context: Context
    ) = FabricConfig(context, fabricEnabled)

    @Provides
    @Singleton
    fun provideFabricReporter(fabricConfig: FabricConfig): Reporter = FabricReporter(fabricConfig)
}

private const val FABRIC_ENABLED = "fabricEnabled"
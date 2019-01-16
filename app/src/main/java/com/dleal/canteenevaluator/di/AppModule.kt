package com.dleal.canteenevaluator.di

import android.content.Context
import com.dleal.canteenevaluator.CanteenApplication
import com.dleal.canteenevaluator.utils.reporting.FabricReporter
import com.dleal.canteenevaluator.utils.reporting.Reporter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(consumerApp: CanteenApplication): Context = consumerApp.applicationContext

    @Provides
    @Singleton
    fun provideFabricReporter(context: Context): Reporter = FabricReporter(context)
}